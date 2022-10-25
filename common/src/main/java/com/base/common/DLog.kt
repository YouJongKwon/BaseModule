package com.base.common

import android.content.Context
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import android.util.Log

object DLog {

    /**
     * application에서 isDebug값 셋팅 필수
     */
    var isDebug = false

    fun init(context: Context) {
        isDebug = isDebug(context)
    }

    /**
     *  태그 자동생성
     *  호출된 클래스명, 메소드명 추가
     */
    private fun getTAG(): String {
        var TAG = "####LOG"
        try {
            val stack = Throwable().fillInStackTrace()
            val trace = stack.stackTrace
            val className = trace[2].className
            val methodName = trace[2].methodName
            TAG = "[####$className] $methodName"
        } catch (e: Exception) {
        }
        return TAG
    }

    /**
     * 디버그 유무 확인
     */
    private fun isDebug(context: Context): Boolean {
        var result = false
        val pm = context.packageManager
        try {
            val appinfo = pm.getApplicationInfo(context.packageName, 0)
            result = (0 != appinfo.flags and ApplicationInfo.FLAG_DEBUGGABLE)
        } catch (e: PackageManager.NameNotFoundException) {
            /* debuggable variable will remain false */
        }
        return result;
    }

    fun d(msg: String) {
        if (isDebug) Log.d(getTAG(), msg)
    }

    fun e(msg: String) {
        if (isDebug) Log.e(getTAG(), msg)
    }


}