package com.zqb.mvpkotlin.di.component

import android.app.Activity

import com.zqb.mvpkotlin.di.module.ActivityModule
import com.zqb.mvpkotlin.di.scope.ActivityScope
import com.zqb.mvpkotlin.ui.main.activity.MainActivity

import dagger.Component

@ActivityScope
@Component(modules = arrayOf(ActivityModule::class))
interface ActivityComponent {

    val activity: Activity

    fun inject(mainActivity: MainActivity)

}
