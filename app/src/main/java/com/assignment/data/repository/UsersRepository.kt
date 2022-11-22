package com.assignment.data.repository

import com.assignment.data.repository.base.BaseApiRepository
import com.assignment.domain.entities.UsersWrapperResponse

class UsersRepository : BaseApiRepository() {

    suspend fun getListData() =
        parseResult(api.getList()) { response -> UsersWrapperResponse(response.meta,response.data).toUserListData()}
}