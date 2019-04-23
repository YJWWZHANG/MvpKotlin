package com.zqb.mvpkotlin.model.net

import android.annotation.SuppressLint
import com.trello.rxlifecycle2.android.ActivityEvent
import com.trello.rxlifecycle2.components.RxActivity
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity
import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * 订阅在io,回调在main
 * 传入fragment会绑定生命周期在destroy的时候取消订阅
 */
fun <T> ioMain(act: RxAppCompatActivity): ObservableTransformer<T, T> {
    return object : ObservableTransformer<T, T> {
        @SuppressLint("CheckResult")
        override fun apply(upstream: Observable<T>): ObservableSource<T> {
            return upstream.compose(act.bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
        }
    }
}

/**
 * 订阅在io,回调在io
 * 传入fragment会绑定生命周期在destroy的时候取消订阅
 */
fun <T> io(act: RxAppCompatActivity): ObservableTransformer<T, T> {
    return object : ObservableTransformer<T, T> {
        @SuppressLint("CheckResult")
        override fun apply(upstream: Observable<T>): ObservableSource<T> {
            return upstream.compose(act.bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(Schedulers.io())
        }
    }
}

