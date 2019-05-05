package com.example.liniary.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.liniary.Activity.DiaryDetailActivity
import com.example.liniary.Model.get.GetDiaryListResponseData
import com.example.liniary.R
import kotlinx.android.synthetic.main.recyclerview_diary_item.view.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.startActivity

class DiaryRecyclerViewAdapter (var context: Context, var dataList:ArrayList<GetDiaryListResponseData>): RecyclerView.Adapter<DiaryRecyclerViewAdapter.Holder>(){
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): DiaryRecyclerViewAdapter.Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.recyclerview_diary_item,p0,false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(p0: DiaryRecyclerViewAdapter.Holder, p1: Int) {
        p0.date.text = dataList[p1].write_date
        Glide.with(context)
            .load(dataList[p1].url)
            .into(p0.image_url)

        p0.container.onClick {
            context.startActivity<DiaryDetailActivity>(
                "diary_data" to dataList[p1].write_date,
                "diary_image" to dataList[p1].url
            )
        }
    }

    inner class Holder(itemview: View): RecyclerView.ViewHolder(itemview){
        var container = itemView.recycler_item
        val image_url : ImageView = itemview.findViewById(R.id.diary_imageview) as ImageView
        val date = itemview.findViewById(R.id.diary_textView) as TextView
    }
}
