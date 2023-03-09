package com.base.basemodule.sample

import android.app.Application
import com.base.common.DLog
import com.base.core.http.RetrofitUtil

class BaseApplication : Application() {

    // fixme - url
    private val baseURL = "https://jsonplaceholder.typicode.com";

    override fun onCreate() {
        super.onCreate()

        DLog.init(this)

        RetrofitUtil.init(baseURL)
    }

}