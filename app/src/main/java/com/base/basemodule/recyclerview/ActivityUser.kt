package com.base.basemodule.recyclerview

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.base.basemodule.databinding.ActivityUserBinding
import com.base.basemodule.recyclerview.adapter.AdapterUser
import com.base.basemodule.recyclerview.datamodel.UserDataModel
import com.base.basemodule.recyclerview.viewmodel.UserViewModel
import com.base.common.BaseActivity

class ActivityUser : BaseActivity() {

    private lateinit var mBinding: ActivityUserBinding
    private val viewModel by lazy {
        ViewModelProvider(this).get(UserViewModel::class.java)
    }
    private val adapterUser = AdapterUser()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        init()
        setEvent()
        observe()
    }

    override fun init() {

        mBinding.recyclerviewTest.adapter = adapterUser

    }

    override fun setEvent() {

        mBinding.tvAdd.setOnClickListener{
            viewModel.addUser(UserDataModel("YJK","010-1111-2222"))
        }

    }

    fun observe(){

        viewModel.userLiveData.observe(this, Observer {
            adapterUser.setList(it)
        })
    }

}