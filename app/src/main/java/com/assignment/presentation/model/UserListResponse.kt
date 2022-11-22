package com.assignment.presentation.model

import com.assignment.domain.entities.MetaResponse

class UserListResponse(
    val meta: Pagination,
    val data: List<User>
)