package com.zqb.mvpkotlin.ui.image

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.zqb.mvpkotlin.R
import com.zqb.mvpkotlin.model.bean.ImageBean

/**
 *创建时间:2019/4/17 18:33
 */
class ImageAdapter(layoutResId: Int = R.layout.item_image, data: MutableList<ImageBean>?) :
    BaseQuickAdapter<ImageBean, BaseViewHolder>(layoutResId, data) {

    override fun convert(helper: BaseViewHolder?, item: ImageBean?) {

    }
}