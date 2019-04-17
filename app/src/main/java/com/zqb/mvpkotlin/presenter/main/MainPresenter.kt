package com.zqb.mvpkotlin.presenter.main

import com.blankj.utilcode.util.LogUtils
import com.zqb.mvpkotlin.base.RxPresenter
import com.zqb.mvpkotlin.base.contract.main.MainContract


import javax.inject.Inject

class MainPresenter @Inject
constructor() : RxPresenter<MainContract.View>(), MainContract.Presenter {

    override fun presenterTest() {
        LogUtils.w("presenterTest")
        mView?.viewTest()
    }
}
