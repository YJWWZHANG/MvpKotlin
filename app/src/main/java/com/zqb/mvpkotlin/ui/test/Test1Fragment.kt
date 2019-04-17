package com.zqb.mvpkotlin.ui.test

import com.zqb.mvpkotlin.R
import com.zqb.mvpkotlin.base.BaseFragment
import com.zqb.mvpkotlin.presenter.test.TestContract
import com.zqb.mvpkotlin.presenter.test.TestPresenter

/**
 *创建时间:2019/4/17 16:24
 */
class Test1Fragment : BaseFragment<TestPresenter>(), TestContract.View {

    override val layoutId: Int
        get() = R.layout.fragment_test1

    override fun initInject() {
        fragmentComponent.inject(this)
        mPresenter.attachView(this)
    }

    override fun initEventAndData() {

    }
}