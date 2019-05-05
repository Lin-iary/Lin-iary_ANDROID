package com.example.liniary.Adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

class MainPagerAdapter (fm: FragmentManager, private val num_fragment:Int): FragmentStatePagerAdapter(fm) {
    override fun getItem(p0: Int): Fragment {
        return when (p0) {
            0 -> DiaryFragment()
            1 -> DrawUpMainFragment()
            2 -> ConsultingFragment()
            3 -> MypageFragment()
            else -> null
        }
    }
    override fun getCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}