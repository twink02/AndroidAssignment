package com.assignment.domain.entities

import com.google.gson.annotations.SerializedName

data class UserItemResponse(
    @SerializedName("id") val id:Long,
    @SerializedName("name") val name:String?,
    @SerializedName("email") val email:String?,
    @SerializedName("gender") val gender:String?,
    @SerializedName("status") val status:String?

)