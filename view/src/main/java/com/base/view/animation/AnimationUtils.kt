package com.base.view.animation

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ValueAnimator
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.animation.AnimationSet
import com.base.common.callback.SingleCallback

/**
 * Animation 유틸
 *
 * - Value Animation
 */
object AnimationUtils {

    val DEFAULT_DURATION: Long = 500

    /**********************************
     * Value animation
     **********************************/
    // basic
    fun startValueAnimation(start: Int, end: Int, callback: SingleCallback<Int>) {
        startValueAnimation(
            start = start,
            end = end,
            duration = DEFAULT_DURATION,
            callback = callback
        )
    }

    // basic + duration + delay
    fun startValueAnimation(
        start: Int,
        end: Int,
        duration: Long,
        delay: Long,
        callback: SingleCallback<Int>
    ) {
        Handler(Looper.getMainLooper()).postDelayed({
            startValueAnimation(start = start, end = end, duration = duration, callback)
        }, delay)
    }

    // basic + duration
    fun startValueAnimation(
        start: Int,
        end: Int,
        duration: Long,
        callback: SingleCallback<Int>
    ) {
        val animator = ValueAnimator.ofInt(start, end)
        animator.duration = duration
        animator.addUpdateListener {
            val value: Int = it.animatedValue as Int
            callback.onResult(value)
        }
        animator.start()
    }

    // 순차적으로 delay를 적용하고 싶을 경우 사용하는 Builder
    class Builder {

        var animatorSet: AnimatorSet = AnimatorSet()

        var delay: Long = 0
        var incrementedDelay: Long = 200

        fun addAnimator(animator: Animator): Builder {
            animatorSet.play(animator).after(delay)
            delay += incrementedDelay
            return this
        }

        fun addAnimator(
            start: Int,
            end: Int,
            duration: Long,
            callback: SingleCallback<Int>
        ): Builder {
            val animator = ValueAnimator.ofInt(start, end)
            animator.duration = duration
            animator.addUpdateListener {
                callback.onResult(it.animatedValue as Int)
            }
            addAnimator(animator)
            return this
        }

        fun addAutoDurationAnimator(
            start: Int,
            end: Int,
            max: Int,
            callback: SingleCallback<Int>
        ): Builder {
            val animator = ValueAnimator.ofInt(start, end)
            animator.duration = (1500 * (end / max.toFloat())).toLong()
            animator.addUpdateListener {
                callback.onResult(it.animatedValue as Int)
            }
            addAnimator(animator)
            return this
        }

        fun start() {
            animatorSet.start()
        }


    }

    // todo other animations..
}