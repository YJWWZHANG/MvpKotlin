package com.zqb.mvpkotlin.ui.main

import android.app.Activity
import android.content.Intent
import com.blankj.utilcode.util.AppUtils
import com.blankj.utilcode.util.LogUtils
import com.blankj.utilcode.util.ToastUtils
import com.yanzhenjie.permission.AndPermission
import com.yanzhenjie.permission.runtime.Permission
import com.zqb.mvpkotlin.R
import com.zqb.mvpkotlin.base.BaseActivity
import com.zqb.mvpkotlin.presenter.main.MainContract
import com.zqb.mvpkotlin.presenter.main.MainPresenter
import com.zqb.mvpkotlin.ui.image.TabFragmentAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity(override val layoutId: Int = R.layout.activity_main) : BaseActivity<MainPresenter>(), MainContract.View {

    companion object {
        fun launch(activity: Activity) {
            activity.startActivity(Intent(activity, MainActivity::class.java))
        }
    }

    private var mExitTime = 0L

    override fun initInject() {
        activityComponent.inject(this)
        mPresenter.attachView(this, this)
    }

    override fun initEventAndData() {
        AndPermission.with(this)
            .runtime()
            .permission(Permission.Group.STORAGE)
            .onGranted { permissions ->
            }
            .onDenied { permissions ->
                ToastUtils.showLong("您拒绝了应用所需要的权限，请手动开启")
            }
            .start()
        mPresenter.presenterTest()
        view_pager.adapter = TabFragmentAdapter(supportFragmentManager)
        tab_layout.setupWithViewPager(view_pager)
    }

    override fun onBackPressed() {
        if (System.currentTimeMillis() - mExitTime > 2000) {
            mExitTime = System.currentTimeMillis()
            ToastUtils.showShort("再按一次退出程序")
        } else {
            AppUtils.exitApp()
        }
    }

    override fun viewTest() {
        LogUtils.w("viewTest")
    }
}
