package com.assignment.data.retrofit

import com.assignment.domain.entities.UsersWrapperResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    companion object {
        const val GET_LIST = "public/v1/users"
    }

    @GET(GET_LIST)
    suspend fun getList(): Response<UsersWrapperResponse>
}