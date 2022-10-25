package com.base.basemodule.http.test

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.base.basemodule.databinding.ActivityHttpBinding
import com.base.basemodule.http.test.datamodel.FriendDataModel
import com.base.basemodule.http.test.viewmodel.FriendViewModel
import com.base.common.callback.ResponseCallback
import com.base.view.activity.BaseActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ActivityHttp : BaseActivity() {

    private lateinit var mBinding: ActivityHttpBinding
    private lateinit var viewModel: FriendViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityHttpBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        init()
        setEvent()
    }

    override fun init() {
        viewModel = ViewModelProvider(this)[FriendViewModel::class.java]
        test()
    }

    override fun setEvent() {

    }

    fun test() {

        GlobalScope.launch {
            viewModel.getRequestFriendList(
                FriendViewModel.TYPE_REQUEST,
                ResponseCallback(onSuccess = {
                    Log.d("#####", "data : $it")
                }, onFailed = { code, msg ->
                    if (msg.isEmpty()) {
                        Log.d("####", msg)
                    } else {
                        Log.d("####", "error code : $code");
                    }
                })
            )
        }

    }


}