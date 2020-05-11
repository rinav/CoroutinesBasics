package dev.rinav.room_sample.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dev.rinav.App
import dev.rinav.room_sample.data.model.LoginState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Created by Rinav Gangar <rinav.dev> on 11/5/20.
 * Agrahyah Technologies Pvt Ltd
 * rinav4all@gmail.com
 */
class LoginViewModel : ViewModel() {

    private val dao = App.instance.database.userDao()
    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    val loginComplete = MutableLiveData<Boolean>()
    val error = MutableLiveData<String>()

    fun login(username: String, password: String) {

        coroutineScope.launch {

            val checkUser = dao.getUser(username)

            if (checkUser == null) {

                withContext(Dispatchers.Main) {
                    error.value = "User not found"
                }
            } else {
                if (checkUser.passwordHash == password.hashCode()) {

                    LoginState.login(checkUser)
                    withContext(Dispatchers.Main) {
                        loginComplete.value = true
                    }
                } else {
                    withContext(Dispatchers.Main) {
                        error.value = "password is incorrect"
                    }
                }
            }
        }
    }
}