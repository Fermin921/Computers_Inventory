package com.example.computers_inventory

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> Description()
            1 -> Especifications()
            else -> Description()
        }
    }

    override fun getCount(): Int {
        return 2 // Número de pestañas
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "Description"
            1 -> "Especifications"
            else -> null
        }
    }
}
