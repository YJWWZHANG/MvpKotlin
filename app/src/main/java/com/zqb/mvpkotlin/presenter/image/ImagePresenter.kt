package com.zqb.mvpkotlin.presenter.image

import android.annotation.SuppressLint
import com.blankj.utilcode.util.ToastUtils
import com.blankj.utilcode.util.Utils
import com.zqb.mvpkotlin.R
import com.zqb.mvpkotlin.base.RxPresenter
import com.zqb.mvpkotlin.model.net.ImageApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import javax.inject.Inject

/**
 *创建时间:2019/4/17 16:22
 */
class ImagePresenter @Inject constructor() : RxPresenter<ImageContract.View>(), ImageContract.Presenter {

    private var mCurrentPage = 0

    @Inject
    lateinit var mRetrofit: Retrofit

    @SuppressLint("CheckResult")
    override fun loadImages(position: Int) {
        mRetrofit.create(ImageApi::class.java)
            .loadImage(Utils.getApp().resources.getStringArray(R.array.tab)[position], mCurrentPage * 48)
            .subscribeOn(Schedulers.io())
            .doOnSubscribe { }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                mView!!.onSuccess(it.items)
                mCurrentPage++
            }, {
                mView!!.onError()
                ToastUtils.showShort(it.message)
            })
    }

}