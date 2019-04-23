package com.zqb.mvpkotlin.base

import android.app.Activity

interface BasePresenter<T : BaseView> {

    fun attachView(view: T, activity: Activity)
    fun detachView()
}
