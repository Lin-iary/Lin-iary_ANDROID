package com.example.liniary.Activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.liniary.Fragment.CommentDialogFragment
import com.example.liniary.R
import kotlinx.android.synthetic.main.activity_diary_detail.*
import kotlinx.android.synthetic.main.fragment_drawup.*
import org.jetbrains.anko.image
import org.jetbrains.anko.toast

class DiaryDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diary_detail)
        val img_url = intent.getStringExtra("diary_image")
        tv_diary_frag_today.text = intent.getStringExtra("diary_date")
        Glide.with(this)
            .load(img_url)
            .thumbnail(0.1f)
            .into(img_diary_frag_diary)
        txt_diary_frag_counselor_name.text = intent.getStringExtra("diary_name")
        txt_diary_frag_conselor_organization.text = intent.getStringExtra("diary_orga")
        txt_diary_frag_comment.text = intent.getStringExtra("diary_content")
        if(txt_diary_frag_conselor_organization.text == "" ||txt_diary_frag_conselor_organization.text == null)
        {
            img_arrow.visibility = View.GONE
            rl_counselor_comment.visibility = View.GONE
            toast("아직 상담이 완료되지 않았어요!")
        }

        setOnBtnClickListener()
    }

    private fun setOnBtnClickListener()
    {
        rl_counselor_comment.setOnClickListener {
            val dialog : CommentDialogFragment = CommentDialogFragment()
            dialog.show(supportFragmentManager,"CommentDialogFragment")
        }
    }

}
