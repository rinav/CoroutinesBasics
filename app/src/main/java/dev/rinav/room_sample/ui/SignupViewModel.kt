package dev.rinav.room_sample.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dev.rinav.App
import dev.rinav.room_sample.data.model.LoginState
import dev.rinav.room_sample.data.model.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Created by Rinav Gangar <rinav.dev> on 11/5/20.
 * Agrahyah Technologies Pvt Ltd
 * rinav4all@gmail.com
 */
class SignupViewModel() : ViewModel() {

    private val dao = App.instance.database.userDao()
    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    val signupComplete = MutableLiveData<Boolean>()
    val error = MutableLiveData<String>()

    fun signup(username: String, password: String, info: String) {

        coroutineScope.launch {

            val user: User? = dao.getUser(username)

            if (user != null) {
                withContext(Dispatchers.Main) {
                    error.value = "User already exists"
                }
            } else {
                val newUser = User(username, password.hashCode(), info)
                val userId = dao.insertUser(newUser)
                newUser.id = userId
                LoginState.login(newUser)

                withContext(Dispatchers.Main) {
                    signupComplete.value = true
                }
            }
        }
    }
}