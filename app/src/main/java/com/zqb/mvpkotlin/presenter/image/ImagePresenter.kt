package com.zqb.mvpkotlin.presenter.image

import com.blankj.utilcode.util.Utils
import com.zqb.mvpkotlin.R
import com.zqb.mvpkotlin.base.RxPresenter
import com.zqb.mvpkotlin.model.bean.ImageBean
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Inject

/**
 *创建时间:2019/4/17 16:22
 */
class ImagePresenter @Inject constructor() : RxPresenter<ImageContract.View>(), ImageContract.Presenter {

    private var mCurrentPage = 0

    override fun loadImages(position: Int) {
        Retrofit.Builder()
            .baseUrl("http://pic.sogou.com")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(ImageApi::class.java)
            .loadImage(Utils.getApp().resources.getStringArray(R.array.tab)[position], mCurrentPage * 48)
            .subscribeOn(Schedulers.io())
            .doOnSubscribe { }
            .observeOn(AndroidSchedulers.mainThread())
            .doOnNext {
                mView!!.setImages(it.items)
                mCurrentPage++
            }
            .doOnComplete { }
            .doOnError { }
            .subscribe()
    }

    interface ImageApi {
        @GET("/pics?reqType=ajax&reqFrom=result")
        fun loadImage(@Query("query") query: String, @Query("start") start: Int): Flowable<ImageBean>
    }

}