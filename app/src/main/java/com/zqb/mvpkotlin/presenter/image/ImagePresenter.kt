package com.zqb.mvpkotlin.presenter.image

import com.blankj.utilcode.util.LogUtils
import com.blankj.utilcode.util.Utils
import com.google.gson.Gson
import com.zqb.mvpkotlin.R
import com.zqb.mvpkotlin.base.RxPresenter
import com.zqb.mvpkotlin.model.bean.ImageBean
import kotlinx.android.synthetic.main.item_image.view.*
import okhttp3.*
import java.io.IOException
import javax.inject.Inject

/**
 *创建时间:2019/4/17 16:22
 */
class ImagePresenter @Inject constructor(): RxPresenter<ImageContract.View>(), ImageContract.Presenter {

    private var mCurrentPage = 0

    override fun loadImages(position: Int) {
        OkHttpClient().newCall(
            Request.Builder().url(
                "http://pic.sogou.com/pics?reqType=ajax&reqFrom=result&query=" + Utils.getApp().resources.getStringArray(
                    R.array.tab)[position] + "&start=" + mCurrentPage * 48
            ).build())
            .enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {

                }

                @Throws(IOException::class)
                override fun onResponse(call: Call, response: Response) {
                    val imageBean = Gson().fromJson(response.body()!!.string(), ImageBean::class.java)
                    mView?.setImages(imageBean.items)
                    mCurrentPage++
                }
            })
    }

}