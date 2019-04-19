package com.zqb.mvpkotlin.presenter.image

import com.blankj.utilcode.util.Utils
import com.zqb.mvpkotlin.R
import com.zqb.mvpkotlin.base.RxPresenter
import com.zqb.mvpkotlin.model.bean.ImageBean
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
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
        val retrofit2 = Retrofit.Builder()
            .baseUrl("http://pic.sogou.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val imageApi = retrofit2.create(ImageApi::class.java)
        val call = imageApi.loadImage(Utils.getApp().resources.getStringArray(R.array.tab)[position], mCurrentPage * 48)
        call.enqueue(object : Callback<ImageBean> {
            override fun onFailure(call: Call<ImageBean>, t: Throwable) {
            }
            override fun onResponse(call: Call<ImageBean>, response: Response<ImageBean>) {
                mView?.setImages(response.body()!!.items)
                mCurrentPage++
            }
        })
    }

    interface ImageApi {
        @GET("/pics?reqType=ajax&reqFrom=result")
        fun loadImage(@Query("query") query: String, @Query("start") start: Int): Call<ImageBean>
    }

}