package com.zqb.mvpkotlin.base

import com.zqb.mvpkotlin.di.component.ActivityComponent
import com.zqb.mvpkotlin.di.component.DaggerActivityComponent
import com.zqb.mvpkotlin.di.module.ActivityModule
import javax.inject.Inject

abstract class BaseActivity<T : BasePresenter<*>> : SimpleActivity(), BaseView{

    @Inject
    protected lateinit var mPresenter : T

    override fun onViewCreated() {
        super.onViewCreated()
        initInject()
    }

    override fun onDestroy() {
        mPresenter.detachView()
        super.onDestroy()
    }

    fun getActivityComponent() : ActivityComponent {
        return DaggerActivityComponent.builder().activityModule(ActivityModule(this)).build()
    }

    abstract fun initInject()

}
