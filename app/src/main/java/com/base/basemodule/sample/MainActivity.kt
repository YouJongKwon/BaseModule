package com.base.basemodule.sample

import android.content.Intent
import android.os.Bundle
import com.base.basemodule.databinding.ActivityMainBinding
import com.base.basemodule.recyclerview.ActivityUser
import com.base.view.activity.BaseActivity

/**
 * Sample - Main 화면 첫실행 화면2
 */
class MainActivity : BaseActivity() {

    private lateinit var mBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        init()
        setEvent()
    }

    override fun init() {
        test()
    }

    override fun setEvent() {

    }

    fun test() {

//        AnimationUtils.startValueAnimation(0, 50, callback = SingleCallback{
//            mBinding.progressbar.progress = it
//        })

        var intent = Intent(this, ActivityUser::class.java)
        startActivity(intent)
    }


}