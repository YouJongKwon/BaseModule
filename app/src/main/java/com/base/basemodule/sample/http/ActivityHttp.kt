package com.base.basemodule.sample.http

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.base.basemodule.databinding.ActivityHttpBinding
import com.base.basemodule.sample.http.viewmodel.PostViewModel
import com.base.common.callback.ResponseCallback
import com.base.view.activity.BaseActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ActivityHttp : BaseActivity() {

    private lateinit var mBinding: ActivityHttpBinding
    private lateinit var viewModel: PostViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityHttpBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        init()
        setEvent()
    }

    override fun init() {
        viewModel = ViewModelProvider(this)[PostViewModel::class.java]
        test()
    }

    override fun setEvent() {

    }

    fun test() {

        // get
        viewModel.getPostList(
            ResponseCallback({
                Log.d("#####", "[get] data : $it")
            },{ code, msg ->
                Log.d("###", "error code : $code, msg : $msg" )
            })
        )

        // post
        viewModel.getPostDetail(ResponseCallback({
            Log.d("####", "[post] data : $it")
        }, { code, msg ->
            Log.d("###", "error code : $code, msg : $msg" )
        }))

        // put
        viewModel.putPost(ResponseCallback({
            Log.d("####", "[put] data : $it")
        }, { code, msg ->
            Log.d("###", "error code : $code, msg : $msg")
        }))

        // patch
        viewModel.patchPost(ResponseCallback({
            Log.d("####", "[patch] data : $it")
        }, { code, msg ->
            Log.d("###", "error code : $code, msg : $msg")
        }))

        // delete
        viewModel.deletePost(ResponseCallback({
            Log.d("####", "[delete] data : $it")
        }, { code, msg ->
            Log.d("###", "error code : $code, msg : $msg")
        }))

    }


}