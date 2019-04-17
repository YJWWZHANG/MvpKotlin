package com.zqb.mvpkotlin.app

import android.app.Application
import com.blankj.utilcode.util.Utils

/**
 *创建时间:2019/4/17 14:06
 */
class App: Application() {

    override fun onCreate() {
        super.onCreate()
        Utils.init(this)
    }
}