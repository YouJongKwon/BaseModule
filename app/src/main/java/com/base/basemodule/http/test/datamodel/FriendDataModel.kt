package com.base.basemodule.http.test.datamodel

class FriendDataModel : ResponseDataModel<ArrayList<FriendDataModel.Data>>() {

    class Data {
        var ResponseID : String = ""
        var ResponseName : String = ""
        var RequestID : String = ""
        var RequestName : String = ""

        override fun toString(): String {
            return "Data(ResponseID='$ResponseID', ResponseName='$ResponseName', RequestID='$RequestID', RequestName='$RequestName')"
        }
    }

}