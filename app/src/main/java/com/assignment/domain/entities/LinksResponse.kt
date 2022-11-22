package com.assignment.domain.entities

import com.google.gson.annotations.SerializedName

data class LinksResponse(
    @SerializedName("previous") val previous: String?,
    @SerializedName("current") val current: String?,
    @SerializedName("next") val next: String?
)