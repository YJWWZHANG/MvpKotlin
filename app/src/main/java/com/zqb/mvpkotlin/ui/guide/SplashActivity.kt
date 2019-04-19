package com.zqb.mvpkotlin.ui.guide

import android.os.Handler
import com.zqb.mvpkotlin.R
import com.zqb.mvpkotlin.base.SimpleActivity
import com.zqb.mvpkotlin.ui.main.MainActivity

/**
 *创建时间:2019/4/17 15:01
 */
class SplashActivity(override val layoutId: Int = R.layout.activity_guide) : SimpleActivity() {

    override fun initEventAndData() {
        Handler().postDelayed({
            MainActivity.launch(this)
            finish()
        }, 2000)

    }

}