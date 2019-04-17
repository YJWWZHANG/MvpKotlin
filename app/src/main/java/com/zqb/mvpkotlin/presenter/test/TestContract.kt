package com.zqb.mvpkotlin.presenter.test

import com.zqb.mvpkotlin.base.BasePresenter
import com.zqb.mvpkotlin.base.BaseView

/**
 *创建时间:2019/4/17 16:20
 */
interface TestContract {

    interface View: BaseView {

    }

    interface Presenter: BasePresenter<View> {

    }
}