package com.zqb.mvpkotlin.base

open class RxPresenter<T : BaseView> : BasePresenter<T> {

    var mView : T? = null

    override fun attachView(view: T) {
        mView = view
    }

    override fun detachView() {
        mView = null
    }
}