package dev.rinav.retrofit_sample.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dev.rinav.retrofit_sample.model.Country
import dev.rinav.retrofit_sample.network.CountriesService
import kotlinx.coroutines.*

/**
 * Created by Rinav Gangar <rinav.dev> on 11/5/20.
 * Agrahyah Technologies Pvt Ltd
 * rinav4all@gmail.com
 */
class ListViewModel : ViewModel() {

    private val countriesService = CountriesService.getCountriesService()

    private var job: Job? = null
    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        onError("Exception: ${throwable.message}")
    }

    val countries = MutableLiveData<List<Country>>()
    val countryLoadError = MutableLiveData<String>()
    val loading = MutableLiveData<Boolean>()

    fun refresh() {
        fetchCountries()
    }

    private fun fetchCountries() {
        loading.value = true

        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {

            val response = countriesService.getCountries()

            withContext(Dispatchers.Main) {

                if (response.isSuccessful) {
                    countries.value = response.body()
                    countryLoadError.value = ""
                    loading.value = false
                } else {
                    onError("Error: ${response.message()}")
                }
            }
        }
    }

    private fun onError(message: String) {
        countryLoadError.value = message
        loading.value = false
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }
}