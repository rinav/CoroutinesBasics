package dev.rinav.room_sample

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * Created by Rinav Gangar <rinav.dev> on 11/5/20.
 * Agrahyah Technologies Pvt Ltd
 * rinav4all@gmail.com
 */
class LoginViewModel : ViewModel() {

    val loginComplete = MutableLiveData<Boolean>()
    val error = MutableLiveData<String>()

    fun login(username: String, password: String) {

    }
}