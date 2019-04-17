package com.zqb.mvpkotlin.di.component

import com.zqb.mvpkotlin.di.module.FragmentModule
import com.zqb.mvpkotlin.ui.image.ImageFragment
import dagger.Component

@Component(modules = [FragmentModule::class])
interface FragmentComponent {

    fun inject(imageFragment: ImageFragment)
}