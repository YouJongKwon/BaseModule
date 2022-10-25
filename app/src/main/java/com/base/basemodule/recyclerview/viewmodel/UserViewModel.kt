package com.base.basemodule.recyclerview.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.base.basemodule.recyclerview.datamodel.NonNullMutableLiveData
import com.base.basemodule.recyclerview.datamodel.UserDataModel

class UserViewModel: ViewModel() {

    var userLiveData = NonNullMutableLiveData(mutableListOf<UserDataModel>())

    fun addUser(user: UserDataModel){
        val userList = userLiveData.value
        userList.add(user)
        userLiveData.postValue(userList)
    }

    fun deleteUser(user: UserDataModel){
        userLiveData.value.filter {
            user.name == it.name && user.tel == it.tel
        }.let {
            userLiveData.value = it as MutableList<UserDataModel>
        }
    }

}