package com.zqb.mvpkotlin.presenter.image

import android.annotation.SuppressLint
import com.blankj.utilcode.util.LogUtils
import com.blankj.utilcode.util.ToastUtils
import com.blankj.utilcode.util.Utils
import com.trello.rxlifecycle2.components.RxActivity
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity
import com.zqb.mvpkotlin.R
import com.zqb.mvpkotlin.base.RxPresenter
import com.zqb.mvpkotlin.model.bean.ImageBean
import com.zqb.mvpkotlin.model.net.ApiRepository
import com.zqb.mvpkotlin.model.net.SougouApi
import com.zqb.mvpkotlin.model.net.ioMain
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
    lateinit var mApiRepository: ApiRepository

    @SuppressLint("CheckResult")
    override fun loadImages(position: Int, isLoadMore: Boolean) {
        if (!isLoadMore) mCurrentPage = 0
        mApiRepository.loadImage(Utils.getApp().resources.getStringArray(R.array.tab)[position], mCurrentPage * 48)
            .compose(ioMain(mActivity as RxAppCompatActivity))
            .doOnSubscribe { }
            .subscribe({
                mView!!.onSuccess(it.items)
                mCurrentPage++
            }, {
                mView!!.onError()
                ToastUtils.showShort(it.message)
                LogUtils.e(it.message)
            })
    }

}