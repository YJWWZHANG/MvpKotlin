package com.zqb.mvpkotlin.model.di.component

import com.zqb.mvpkotlin.model.di.module.FragmentModule
import com.zqb.mvpkotlin.model.di.module.NetworkModule
import com.zqb.mvpkotlin.model.di.scope.FragmentScope
import com.zqb.mvpkotlin.ui.image.ImageFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@FragmentScope
@Component(modules = [FragmentModule::class, NetworkModule::class])
interface FragmentComponent {

    fun inject(imageFragment: ImageFragment)
}