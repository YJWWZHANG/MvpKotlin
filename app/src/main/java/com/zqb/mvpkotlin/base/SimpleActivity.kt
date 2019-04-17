package com.zqb.mvpkotlin.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

abstract class SimpleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        onViewCreated()
        initEventAndData()
    }

    protected open fun onViewCreated() {
    }

    abstract fun getLayoutId(): Int
    abstract fun initEventAndData()
}