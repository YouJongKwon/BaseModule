package com.base.basemodule.http.test.datamodel

open class ResponseDataModel<T>{
    var DATA : T? = null

    var DATA_TYPE = ""
    var TOTAL = 0
    var ACTION = 0
    var ERROR = false

    // todo
    var ERROR_CODE = -1
    var ERROR_MSG = ""

    override fun toString(): String {
        return "ResponseDataModel(DATA=${DATA.toString()}, DATA_TYPE='$DATA_TYPE', TOTAL=$TOTAL, ACTION=$ACTION, ERROR=$ERROR)"
    }

}