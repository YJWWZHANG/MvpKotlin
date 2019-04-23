package com.zqb.mvpkotlin.base

import android.app.Activity

open class RxPresenter<T : BaseView> : BasePresenter<T> {

    var mView : T? = null
    var mActivity : Activity? = null

    override fun attachView(view: T, activity: Activity) {
        mView = view
        mActivity = activity
    }

    override fun detachView() {
        mView = null
    }
}