package com.base.common

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.base.common.DLog

abstract class BaseActivity : AppCompatActivity() {

    protected var mContext : Context = this

    protected abstract fun init()

    protected abstract fun setEvent()

    /**
     * status bar
     */
    protected open fun setStatusBarColor(isWhiteIcon: Boolean, isFullScreen: Boolean, color: Int) {
        try {
            WindowInsetsControllerCompat(window, window.decorView).isAppearanceLightStatusBars =
                !isWhiteIcon
            window.statusBarColor = color
            if (isFullScreen) setFullScreen()
        } catch (e: Exception) {
            DLog.d(e.localizedMessage)
        }
    }

    /**
     * status bar & system bar 제거
     */
    protected open fun setFullScreen() {
        setFullScreen(true, true)
    }
    protected open fun setFullScreen(isHideStatusBar: Boolean, isHideSystemBar: Boolean) {
        try {
            if (isHideStatusBar) {
                WindowInsetsControllerCompat(
                    window,
                    window.decorView
                ).hide(WindowInsetsCompat.Type.statusBars())
            } else {
                WindowInsetsControllerCompat(
                    window,
                    window.decorView
                ).show(WindowInsetsCompat.Type.statusBars())
            }
            if (isHideSystemBar) {
                WindowInsetsControllerCompat(
                    window,
                    window.decorView
                ).hide(WindowInsetsCompat.Type.systemBars())
            } else {
                WindowInsetsControllerCompat(
                    window,
                    window.decorView
                ).show(WindowInsetsCompat.Type.systemBars())
            }
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
    }

    /**
     * status bar 제거
     */
    protected open fun setTranslucentBar() {
        try {
            WindowInsetsControllerCompat(
                window,
                window.decorView
            ).hide(WindowInsetsCompat.Type.statusBars())
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
    }

    /**
     * simple dialog
     */

    /**
     *
     */


}