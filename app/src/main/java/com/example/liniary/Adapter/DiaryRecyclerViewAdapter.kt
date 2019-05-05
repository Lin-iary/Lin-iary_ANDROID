package com.example.liniary.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.liniary.Model.DiaryData
import com.example.liniary.R
import kotlinx.android.synthetic.main.recyclerview_diary_item.view.*

class DiaryRecyclerViewAdapter (var context: Context, var dataList:ArrayList<DiaryData>): RecyclerView.Adapter<DiaryRecyclerViewAdapter.Holder>(){
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): DiaryRecyclerViewAdapter.Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.recyclerview_diary_item,p0,false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(p0: DiaryRecyclerViewAdapter.Holder, p1: Int) {
        p0.date.text = dataList[p1].diary_date
        Glide.with(context)
            .load(dataList[p1].diary_image)
            .into(p0.image)
    }

    inner class Holder(itemview: View): RecyclerView.ViewHolder(itemview){
        val image = itemview.diary_imageview
        val date = itemview.diary_textView
    }
}