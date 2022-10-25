package com.base.basemodule

import android.app.Application
import com.base.common.DLog
import com.base.core.http.RetrofitUtil

class BaseApplication : Application() {

    private val baseURL = "http://api.88care.co.kr";

    override fun onCreate() {
        super.onCreate()

        DLog.init(this)

        RetrofitUtil.init(baseURL)
    }

}