package com.zqb.mvpkotlin.di.component

import com.zqb.mvpkotlin.di.module.FragmentModule
import com.zqb.mvpkotlin.ui.test.Test1Fragment
import dagger.Component

@Component(modules = [FragmentModule::class])
interface FragmentComponent {

    fun inject(test1Fragment: Test1Fragment)
}