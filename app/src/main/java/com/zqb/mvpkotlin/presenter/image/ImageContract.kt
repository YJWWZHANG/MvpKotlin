package com.zqb.mvpkotlin.presenter.image

import com.zqb.mvpkotlin.base.BasePresenter
import com.zqb.mvpkotlin.base.BaseView

/**
 *创建时间:2019/4/17 16:20
 */
interface ImageContract {

    interface View: BaseView {

    }

    interface Presenter: BasePresenter<View> {

    }
}