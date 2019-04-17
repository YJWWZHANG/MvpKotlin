package com.zqb.mvpkotlin.ui.image

import com.zqb.mvpkotlin.R
import com.zqb.mvpkotlin.base.BaseFragment
import com.zqb.mvpkotlin.presenter.image.ImageContract
import com.zqb.mvpkotlin.presenter.image.ImagePresenter

/**
 *创建时间:2019/4/17 16:24
 */
class ImageFragment : BaseFragment<ImagePresenter>(), ImageContract.View {

    override val layoutId: Int
        get() = R.layout.fragment_image

    override fun initInject() {
        fragmentComponent.inject(this)
        mPresenter.attachView(this)
    }

    override fun initEventAndData() {

    }
}