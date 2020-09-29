package com.ishaanjain.redcarpetinternship.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import com.ishaanjain.redcarpetinternship.R
import com.ishaanjain.redcarpetinternship.ui.adapters.ViewPagerAdapter
import kotlinx.android.synthetic.main.activity_top_headline.*

class TopHeadlineActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_top_headline)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Home"

        tabLayout.addTab(tabLayout.newTab().setText("Headlines in India"))
        tabLayout.addTab(tabLayout.newTab().setText("Headlines in USA"))
        tabLayout.addTab(tabLayout.newTab().setText("Headlines in UK"))
        tabLayout.tabGravity = TabLayout.GRAVITY_FILL

        val mAdapter = ViewPagerAdapter(supportFragmentManager, tabLayout.tabCount)
        viewPager.adapter = mAdapter

        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                viewPager.currentItem = tab!!.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                viewPager.currentItem = tab!!.position
            }

        })
    }

    override fun onBackPressed() {
        val backIntent = Intent(this, HomeActivity::class.java)
        startActivity(backIntent)
    }
}