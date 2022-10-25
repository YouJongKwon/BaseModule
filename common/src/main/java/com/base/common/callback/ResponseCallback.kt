package com.base.common.callback

/**
 * 통신 콜백
 */
class ResponseCallback<T>(val onSuccess: (T) -> Unit, val onFailed: (Int, String) -> Unit)