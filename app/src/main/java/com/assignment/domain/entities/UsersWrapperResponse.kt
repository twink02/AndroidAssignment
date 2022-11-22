package com.assignment.domain.entities

import com.assignment.presentation.model.User
import com.assignment.presentation.model.UserListResponse
import com.google.gson.annotations.SerializedName

class UsersWrapperResponse(
    @SerializedName("meta") val meta: MetaResponse,
    @SerializedName("data") val data: List<UserItemResponse>
) {
    fun toUserListData() = UserListResponse(
        meta.toPagination(),
        data.map { User(it.id, it.name, it.email, it.gender, it.status) })
}
