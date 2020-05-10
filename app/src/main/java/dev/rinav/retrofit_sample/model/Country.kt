package dev.rinav.retrofit_sample.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Rinav Gangar <rinav.dev> on 11/5/20.
 * Agrahyah Technologies Pvt Ltd
 * rinav4all@gmail.com
 */
data class Country(
    @field:SerializedName("name")
    val countryName: String?,

    @field:SerializedName("capital")
    val capital: String?,

    @field:SerializedName("flagPNG")
    val flag: String?
)
