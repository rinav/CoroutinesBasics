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
class HomeViewModel : ViewModel() {

    private val dao = App.instance.database.userDao()
    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    val userDeleted = MutableLiveData<Boolean>()
    val signout = MutableLiveData<Boolean>()

    fun onSignout() {
        LoginState.logout()
        signout.value = true
    }

    fun onDeleteUser() {

        coroutineScope.launch {

            LoginState.user?.let {
                dao.deleteUser(it.id)
            }

            withContext(Dispatchers.Main) {
                LoginState.logout()
                userDeleted.value = true
            }
        }
    }
}