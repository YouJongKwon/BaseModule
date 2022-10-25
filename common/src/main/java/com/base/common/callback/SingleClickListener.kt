package com.base.common.callback

import android.os.SystemClock
import android.view.View
import java.lang.Exception

class SingleClickListener (val onClick:(View?)->Unit): View.OnClickListener{

    var mLastClickTime: Long = 0
    val delay = 1000

    override fun onClick(view: View?) {
        try {
            if(SystemClock.elapsedRealtime() - mLastClickTime < delay) {
                return
            }else {
                mLastClickTime = SystemClock.elapsedRealtime()
                onClick(view)
            }
        }catch (e : Exception){
            e.printStackTrace()
        }
    }
}