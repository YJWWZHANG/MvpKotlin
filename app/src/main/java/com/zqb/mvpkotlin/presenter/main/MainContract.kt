package com.zqb.mvpkotlin.presenter.main

import com.zqb.mvpkotlin.base.BasePresenter
import com.zqb.mvpkotlin.base.BaseView

interface MainContract {

    interface View : BaseView {
        fun viewTest()
    }

    interface Presenter : BasePresenter<View> {
        fun presenterTest()
    }
}
