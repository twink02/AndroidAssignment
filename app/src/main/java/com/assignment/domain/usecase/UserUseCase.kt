package com.assignment.domain.usecase

import com.assignment.data.repository.UsersRepository
import com.assignment.domain.base.UseCase
import com.assignment.domain.entities.Result
import com.assignment.presentation.model.UserListResponse

class UserUseCase : UseCase<UserListResponse>() {

    private val repository by lazy { UsersRepository() }

    override suspend fun makeRequest(): Result<UserListResponse> =
        repository.getListData()


    fun fetchData(success: (UserListResponse) -> Unit, failure: (Exception) -> Unit) {
        execute(success, failure)
    }
}