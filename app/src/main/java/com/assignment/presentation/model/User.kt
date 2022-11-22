package com.assignment.presentation.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
class User(
    val id: Long,
    val name: String?,
    val email: String?,
    val gender: String?,
    val status: String?
) : Parcelable

