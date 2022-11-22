package com.assignment.domain.entities

import com.assignment.presentation.model.Pagination
import com.google.gson.annotations.SerializedName

data class MetaResponse(
    @SerializedName("pagination") val pagination: PaginationResponse
){
    fun toPagination()=Pagination(pagination.total,pagination.pages,pagination.page,pagination.limit)
}