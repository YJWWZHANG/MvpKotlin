package com.zqb.mvpkotlin.presenter.image

import com.zqb.mvpkotlin.base.BasePresenter
import com.zqb.mvpkotlin.base.BaseView
import com.zqb.mvpkotlin.model.bean.ImageBean

/**
 *创建时间:2019/4/17 16:20
 */
interface ImageContract {

    interface View: BaseView {
        fun setImages(images: List<ImageBean.Item>)
    }

    interface Presenter: BasePresenter<View> {
        fun loadImages(position: Int)
    }
}