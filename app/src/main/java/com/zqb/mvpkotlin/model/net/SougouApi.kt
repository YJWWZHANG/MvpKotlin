package com.zqb.mvpkotlin.model.net

import com.zqb.mvpkotlin.model.bean.ImageBean
import io.reactivex.Flowable
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface SougouApi {

    @GET("/pics")
    fun loadImage(
        @Query("query") query: String,
        @Query("start") start: Int,
        @Query("reqType") reqType: String = "ajax",
        @Query("reqFrom") reqFrom: String = "result"
    ): Observable<ImageBean>

}
