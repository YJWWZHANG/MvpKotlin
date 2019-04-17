package com.zqb.mvpkotlin.base

import android.os.Bundle
import android.view.View
import com.zqb.mvpkotlin.di.component.DaggerFragmentComponent
import com.zqb.mvpkotlin.di.component.FragmentComponent

import javax.inject.Inject

abstract class BaseFragment<T : BasePresenter<*>> : SimpleFragment(), BaseView {

    @Inject
    protected lateinit var mPresenter : T
    protected val fragmentComponent: FragmentComponent
        get() = DaggerFragmentComponent.builder().build()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initInject()
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        mPresenter.detachView()
        super.onDestroyView()
    }

    protected abstract fun initInject()
}