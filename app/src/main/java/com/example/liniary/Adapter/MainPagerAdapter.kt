package com.example.liniary.Adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import  com.example.liniary.Fragment.ConsultingFragment
import com.example.liniary.Fragment.DiaryFragment
import com.example.liniary.Fragment.DrawUpMainFragment
import com.example.liniary.Fragment.MypageFragment

class MainPagerAdapter (fm: FragmentManager, private val num_fragment:Int): FragmentStatePagerAdapter(fm) {
    override fun getItem(p0: Int): Fragment? {
        return when (p0) {
            0 -> DiaryFragment()
            1 -> DrawUpMainFragment()
            2 -> ConsultingFragment()
            3 -> MypageFragment()
            else -> null
        }
    }
    override fun getCount(): Int {
        return num_fragment
    }
}