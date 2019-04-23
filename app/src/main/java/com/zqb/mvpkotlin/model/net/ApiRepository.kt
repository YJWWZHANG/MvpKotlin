package com.zqb.mvpkotlin.model.net

import com.zqb.mvpkotlin.model.bean.ImageBean
import io.reactivex.Flowable
import io.reactivex.Observable
import javax.inject.Inject

/**
 *创建时间:2019/4/22 10:11
 */
class ApiRepository @Inject constructor(
    var sougouApi: SougouApi
) {

    fun loadImage(query: String, start: Int): Observable<ImageBean> {
        return sougouApi.loadImage(query, start)

    }


}