package com.assignment.domain.entities

import com.google.gson.annotations.SerializedName

data class ApiResponseWrapper<out T>(
    @SerializedName("data") val data: T? = null,
    @SerializedName("error") val error: String = "",
    @SerializedName("status") val message: Boolean = false
)
