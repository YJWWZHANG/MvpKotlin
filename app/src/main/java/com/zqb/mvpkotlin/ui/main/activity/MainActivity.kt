package com.zqb.mvpkotlin.ui.main.activity

import com.blankj.utilcode.util.AppUtils
import com.blankj.utilcode.util.LogUtils
import com.zqb.mvpkotlin.R
import com.zqb.mvpkotlin.base.BaseActivity
import com.zqb.mvpkotlin.base.contract.main.MainContract
import com.zqb.mvpkotlin.presenter.main.MainPresenter

class MainActivity : BaseActivity<MainPresenter>(), MainContract.View {

    override fun initInject() {
        getActivityComponent().inject(this)
        mPresenter.attachView(this)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initEventAndData() {
        mPresenter.presenterTest()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        AppUtils.exitApp()
    }

    override fun viewTest() {
        LogUtils.w("viewTest")
    }
}
