package com.example.liniary.Fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.liniary.Adapter.DiaryRecyclerViewAdapter
import com.example.liniary.Model.get.GetDiaryListResponse
import com.example.liniary.Model.get.GetDiaryListResponseData
import com.example.liniary.Network.ApplicationController
import com.example.liniary.Network.NetworkService
import com.example.liniary.R
import kotlinx.android.synthetic.main.fragment_diary.*
import org.jetbrains.anko.support.v4.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DiaryFragment  : Fragment() {

    val networkService: NetworkService by lazy {
        ApplicationController.instance.networkService
    }

    lateinit var diaryRecyclerViewAdapter : DiaryRecyclerViewAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_diary, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        var dataList: ArrayList<GetDiaryListResponseData> = ArrayList()
        diaryRecyclerViewAdapter  = DiaryRecyclerViewAdapter(context!!, dataList)
        recyclerview_diary.layoutManager = GridLayoutManager(context!!, 3)
        recyclerview_diary.adapter = diaryRecyclerViewAdapter
        getDiaryListResponse()

    }

    private fun getDiaryListResponse()
    {
        val getDiaryListResponse = networkService.getDiaryListResponse()
        getDiaryListResponse.enqueue(object : Callback<GetDiaryListResponse> {

            override fun onFailure(call: Call<GetDiaryListResponse>, t: Throwable) {
                Log.e("write fail", t.toString())
            }

            override fun onResponse(
                call: Call<GetDiaryListResponse>, response: Response<GetDiaryListResponse>
            ) {
                if (response.isSuccessful) {
                    if (response.body()!!.status == 200) {
                        val temp: ArrayList<GetDiaryListResponseData> = response.body()!!.data
                        Log.v("DiaryFragment","diary load success")
                        if(temp!=null)
                        {
                            if(temp.size>0)
                            {
                                diaryRecyclerViewAdapter.dataList.removeAll(diaryRecyclerViewAdapter.dataList)
                                diaryRecyclerViewAdapter.dataList.addAll(temp)
                                Log.v("DiaryFragment", "picks data size : ${temp.size}")
                                diaryRecyclerViewAdapter.notifyDataSetChanged()
                            }
                        }
                    } else {
                        toast(response.body()!!.message)
                    }
                }
            }
        })

    }

}