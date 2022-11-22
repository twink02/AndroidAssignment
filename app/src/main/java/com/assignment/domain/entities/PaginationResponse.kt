package com.assignment.domain.entities

import com.google.gson.annotations.SerializedName

data class PaginationResponse(
    @SerializedName("total") val total: Long,
    @SerializedName("pages") val pages: Long,
    @SerializedName("page") val page: Long,
    @SerializedName("limit") val limit: Int
    )