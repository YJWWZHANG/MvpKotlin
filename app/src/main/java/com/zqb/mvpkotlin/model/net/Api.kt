package com.zqb.mvpkotlin.model.net

import com.zqb.mvpkotlin.model.bean.ImageBean
import retrofit2.http.GET
import java.util.*


/**
 *创建时间:2019/4/18 10:24
 */
interface Api {

    companion object {
        val BASE_HOST = "http://pic.sogou.com"
    }

    @GET("http://pic.sogou.com/pics")
    fun getSpeciality()

}