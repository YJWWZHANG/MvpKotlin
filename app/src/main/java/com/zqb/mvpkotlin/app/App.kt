package com.zqb.mvpkotlin.app

import android.annotation.SuppressLint
import android.app.Application
import com.blankj.utilcode.util.CrashUtils
import com.blankj.utilcode.util.Utils

/**
 *创建时间:2019/4/17 14:06
 */
class App: Application() {

    @SuppressLint("MissingPermission")
    override fun onCreate() {
        super.onCreate()
        Utils.init(this)
        CrashUtils.init(externalCacheDir.path)
    }
}