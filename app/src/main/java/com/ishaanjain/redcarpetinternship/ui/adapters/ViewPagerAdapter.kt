package com.ishaanjain.redcarpetinternship.ui.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.ishaanjain.redcarpetinternship.ui.view.fragments.IndiaFragment
import com.ishaanjain.redcarpetinternship.ui.view.fragments.UkFragment
import com.ishaanjain.redcarpetinternship.ui.view.fragments.UsaFragment

class ViewPagerAdapter(fragmentManager: FragmentManager, private val totalTabs: Int) :
    FragmentPagerAdapter(
        fragmentManager,
        FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
    ) {
    override fun getCount(): Int = totalTabs

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                IndiaFragment()
            }
            1 -> {
                UsaFragment()
            }
            2 -> {
                UkFragment()
            }
            else -> Fragment()
        }
    }
}