package com.example.liniary.Fragment

import android.app.Activity
import android.content.CursorLoader
import android.content.Intent
import android.content.pm.PackageManager
import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.support.v4.app.ActivityCompat
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import java.util.*

import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.liniary.R

import kotlinx.android.synthetic.main.fragment_drawup.*
import java.text.SimpleDateFormat


class DrawUpMainFragment : Fragment(){
    val REQUEST_CODE_SELECT_IMAGE: Int = 1004 //startActivityForResult에서 쓰임 다른 액티비티 띄운다음에 결과를 보내줌.
    val My_READ_STORAGE_REQUEST_CODE :Int = 7777

    var imageURI : String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view : View = inflater.inflate(R.layout.fragment_drawup, container, false)

        return view
    }

    fun setDate()
    {
        val now = System.currentTimeMillis()
        val date = Date(now)
        val sdfNow = SimpleDateFormat("yyyy년 MM월 dd일")
        val formatDate = sdfNow.format(date)
        val dateNow: TextView = view!!.findViewById(R.id.tv_drawup_frag_today)
        dateNow.setText(formatDate)
    }

    fun setOnbtnClickListener()
    {
        val btnUploadPhoto : TextView =view!!.findViewById(R.id.txt_frag_drawup_upload_photo) as TextView
        btnUploadPhoto.setOnClickListener {
            requestReadExternalStoragePermission()
        }
        val btnSave : TextView = view!!.findViewById(R.id.btn_frag_drawup_save) as TextView
        btnSave.setOnClickListener {
            //서버에 보내기
        }
    }

    private fun requestReadExternalStoragePermission(){
        if(ContextCompat.checkSelfPermission(activity!!,  android.Manifest.permission.READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
            if(ActivityCompat.shouldShowRequestPermissionRationale(activity!!,android.Manifest.permission.READ_EXTERNAL_STORAGE)){
                //사용자에게 왜 권한을 허용해야되는지에 메시지를 주기위한 로직.
            }else{
                ActivityCompat.requestPermissions(activity!!, arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE),My_READ_STORAGE_REQUEST_CODE)
            }
        }else{
            showAlbum()
        }
    }
    //Uri에 대한 절대 경로를 리턴하는 메소드.
    fun getRealPathFromURI(content : Uri) : String {
        val proj = arrayOf(MediaStore.Images.Media.DATA)
        val loader : CursorLoader = CursorLoader(activity!!, content, proj, null, null, null)
        val cursor : Cursor = loader.loadInBackground()
        val column_idx = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
        cursor.moveToFirst()
        val result = cursor.getString(column_idx)
        cursor.close()
        return result
    }

    private fun showAlbum(){
        val intent = Intent(Intent.ACTION_PICK)
        intent.type= android.provider.MediaStore.Images.Media.CONTENT_TYPE
        intent.data = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        startActivityForResult(intent,REQUEST_CODE_SELECT_IMAGE)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setDate()
        setOnbtnClickListener()
    }

    //앨범에서 사진을 선택했을때 실행되는 메소드
    //startActivityForResult를 통해 실행한 액티비티에 대한 callback을 처리하는 메소드입니다!
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_SELECT_IMAGE) {
            if (resultCode == Activity.RESULT_OK) {
                //data.data에는 앨범에서 선택한 사진의 Uri가 들어있습니다!! 그러니까 제대로 선택됐는지 null인지 아닌지를 체크!
                if(data != null ){
                    val selectImageUri : Uri = data.data
                    //Uri를 getRealPathFromURI라는 메소드를 통해 절대 경로를 알아내고, 인스턴스 변수 imageURI에 넣어줍니다!
                    imageURI = getRealPathFromURI(selectImageUri)

                    Glide.with(activity!!)
                        .load(selectImageUri)
                        .thumbnail(0.1f)
                        .into(img_drawup_frag_diary)

                }
            }
        }
    }

}