package com.zqb.mvpkotlin.ui.image

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.blankj.utilcode.util.Utils
import android.os.Bundle
import com.zqb.mvpkotlin.R

/**
 *创建时间:2019/4/17 17:51
 */
class TabFragmentAdapter(fm: FragmentManager?) : FragmentStatePagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        val fragment = ImageFragment()
        val bundle = Bundle()
        bundle.putInt(ImageFragment.POSITION, position)
        fragment.arguments = bundle
        return fragment
    }

    override fun getCount(): Int {
        return Utils.getApp().resources.getStringArray(com.zqb.mvpkotlin.R.array.tab).size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return Utils.getApp().resources.getStringArray(R.array.tab)[position]
    }
}