package com.zqb.mvpkotlin.model.di.component

import com.zqb.mvpkotlin.model.di.module.ActivityModule
import com.zqb.mvpkotlin.model.di.scope.ActivityScope
import com.zqb.mvpkotlin.ui.main.MainActivity
import dagger.Component

@ActivityScope
@Component(modules = arrayOf(ActivityModule::class))
interface ActivityComponent {

    fun inject(mainActivity: MainActivity)

}
