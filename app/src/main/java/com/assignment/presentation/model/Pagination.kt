package com.assignment.presentation.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Pagination(
    val total: Long,
    val pages: Long,
    val page: Long,
    val limit: Int
) : Parcelable
