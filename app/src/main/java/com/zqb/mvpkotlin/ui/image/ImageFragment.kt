package com.zqb.mvpkotlin.ui.image

import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import com.chad.library.adapter.base.BaseQuickAdapter
import com.zqb.mvpkotlin.R
import com.zqb.mvpkotlin.base.BaseFragment
import com.zqb.mvpkotlin.model.bean.ImageBean
import com.zqb.mvpkotlin.presenter.image.ImageContract
import com.zqb.mvpkotlin.presenter.image.ImagePresenter
import kotlinx.android.synthetic.main.fragment_image.*

/**
 *创建时间:2019/4/17 16:24
 */
class ImageFragment : BaseFragment<ImagePresenter>(), ImageContract.View {

    companion object {
        val POSITION = "position"
    }

    private lateinit var mImageAdapter: ImageAdapter

    override val layoutId: Int
        get() = R.layout.fragment_image

    override fun initInject() {
        fragmentComponent.inject(this)
        mPresenter.attachView(this)
    }

    override fun initEventAndData() {
        recycler_view.layoutManager = StaggeredGridLayoutManager(2, RecyclerView.VERTICAL)
        recycler_view.addItemDecoration(ImageItemDecoration())
        mImageAdapter = ImageAdapter(data = ArrayList())
        mImageAdapter.bindToRecyclerView(recycler_view)
        mImageAdapter.setOnLoadMoreListener({ mPresenter.loadImages(arguments!!.getInt(POSITION)) }, recycler_view)
        mPresenter.loadImages(arguments!!.getInt(POSITION))
    }

    override fun setImages(images: List<ImageBean.Item>) {
        mImageAdapter.addData(images)
        mImageAdapter.loadMoreComplete()
    }
}