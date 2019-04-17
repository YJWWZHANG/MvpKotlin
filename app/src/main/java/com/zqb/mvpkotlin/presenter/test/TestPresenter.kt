package com.zqb.mvpkotlin.presenter.test

import com.zqb.mvpkotlin.base.RxPresenter
import javax.inject.Inject

/**
 *创建时间:2019/4/17 16:22
 */
class TestPresenter @Inject constructor(): RxPresenter<TestContract.View>(), TestContract.Presenter {

}