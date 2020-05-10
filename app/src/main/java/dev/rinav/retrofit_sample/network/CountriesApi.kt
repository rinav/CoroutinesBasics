package dev.rinav.retrofit_sample.network

import dev.rinav.retrofit_sample.model.Country
import retrofit2.Response
import retrofit2.http.GET

/**
 * Created by Rinav Gangar <rinav.dev> on 11/5/20.
 * Agrahyah Technologies Pvt Ltd
 * rinav4all@gmail.com
 */
interface CountriesApi {

    @GET("rinav/aa9500cb83e2f90d42eb282fd2621535/raw/d0278561d5c1d425bae505666d86e147f721f500/countries.json")
    suspend fun getCountries(): Response<List<Country>>
}