package com.example.liniary.Fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.liniary.Adapter.DiaryRecyclerViewAdapter
import com.example.liniary.Model.DiaryData
import com.example.liniary.R
import kotlinx.android.synthetic.main.fragment_diary.*

class DiaryFragment  : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_diary, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        var dataList: ArrayList<DiaryData> = ArrayList()

        dataList.add(
            DiaryData(
                "http://13.124.195.67:3000/images/38e8b9cecfcfa0357c29d424e191013e",
                "0"
            )
        )
        dataList.add(
            DiaryData(
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTpNk4zEZrgm4AY9dBfIV9vcQHMeIpDBay9vv_wZAQodPgi1qTP5Q",
                "0"
            )
        )
        dataList.add(
            DiaryData(
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTpNk4zEZrgm4AY9dBfIV9vcQHMeIpDBay9vv_wZAQodPgi1qTP5Q",
                "0"
            )
        )
        dataList.add(
            DiaryData(
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTpNk4zEZrgm4AY9dBfIV9vcQHMeIpDBay9vv_wZAQodPgi1qTP5Q",
                "0"
            )
        )
        dataList.add(
            DiaryData(
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTpNk4zEZrgm4AY9dBfIV9vcQHMeIpDBay9vv_wZAQodPgi1qTP5Q",
                "0"
            )
        )
        dataList.add(
            DiaryData(
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTpNk4zEZrgm4AY9dBfIV9vcQHMeIpDBay9vv_wZAQodPgi1qTP5Q",
                "0"
            )
        )
        dataList.add(
            DiaryData(
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTpNk4zEZrgm4AY9dBfIV9vcQHMeIpDBay9vv_wZAQodPgi1qTP5Q",
                "0"
            )
        )
        dataList.add(
            DiaryData(
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTpNk4zEZrgm4AY9dBfIV9vcQHMeIpDBay9vv_wZAQodPgi1qTP5Q",
                "0"
            )
        )

        //
        recyclerview_diary.adapter = DiaryRecyclerViewAdapter(context!!, dataList)
        recyclerview_diary.layoutManager = GridLayoutManager(context!!, 3)

    }
}