package com.example.liniary.Activity

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import com.example.liniary.Adapter.MainPagerAdapter
import com.example.liniary.R
import kotlinx.android.synthetic.main.activity_content.*
import kotlinx.android.synthetic.main.navigation_main.view.*

class ContentActivity : AppCompatActivity(), TabLayout.OnTabSelectedListener {
    override fun onTabReselected(p0: TabLayout.Tab?) {

    }

    override fun onTabUnselected(p0: TabLayout.Tab?) {

    }

    override fun onTabSelected(p0: TabLayout.Tab?) {
        viewpager_main.currentItem = p0!!.position
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content)
        configureMainTab()
    }
    private fun configureMainTab() {
        viewpager_main.adapter = MainPagerAdapter(supportFragmentManager, 4)
        viewpager_main.offscreenPageLimit = 2
        tl_main_category.setupWithViewPager(viewpager_main)

        val navCategoryMainLayout: View =
            (this.getSystemService(android.content.Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater)
                .inflate(R.layout.navigation_main, null, false)
        tl_main_category.getTabAt(0)!!.customView =
            navCategoryMainLayout.navigation_category_diary
        tl_main_category.getTabAt(1)!!.customView =
            navCategoryMainLayout.navigation_category_drawup
        tl_main_category.getTabAt(2)!!.customView =
            navCategoryMainLayout.navigation_category_consulting
        tl_main_category.getTabAt(3)!!.customView =
            navCategoryMainLayout.navigation_category_page



    }

}

