package com.zqb.mvpkotlin.base

import android.os.Bundle
import com.noober.background.BackgroundLibrary
import me.yokeyword.fragmentation.SupportActivity
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

abstract class SimpleActivity : SupportActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        BackgroundLibrary.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
        EventBus.getDefault().register(this)
        onViewCreated()
        initEventAndData()
    }

    override fun onDestroy() {
        super.onDestroy()
        EventBus.getDefault().unregister(this)
    }

    protected open fun onViewCreated() {
    }

    protected abstract val layoutId: Int
    abstract fun initEventAndData()

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onMessageNothingEvent(s: String) {

    }
}