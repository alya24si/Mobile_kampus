package com.example.cintaku.Home.pertemuan_13

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.cintaku.Home.pertemuan_10.TabAFragment
import com.example.cintaku.Home.pertemuan_10.TabBFragment
import com.example.cintaku.Home.pertemuan_10.TabCFragment

class ThirteenthTabsAdapter(
    fragmentActivity: FragmentActivity
) : FragmentStateAdapter(fragmentActivity) {

    // Jumlah total tab
    override fun getItemCount(): Int = 3

    // Fragment yang ditampilkan sesuai posisi
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> TabCaptureFragment()
            1 -> TabQrcodeFragment()
            2 -> TabScanFragment()
            else -> throw IllegalStateException("Posisi tidak valid")
        }
    }
}