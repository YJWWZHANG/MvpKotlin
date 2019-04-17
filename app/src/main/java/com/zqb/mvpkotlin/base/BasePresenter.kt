package com.zqb.mvpkotlin.base

interface BasePresenter<T : BaseView> {

    fun attachView(view: T)
    fun detachView()
}
