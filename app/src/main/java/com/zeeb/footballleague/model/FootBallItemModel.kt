package com.zeeb.footballleague.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FootBallItemModel(
    val foto: Int?,
    val nama: String?,
    val deskripsi: String?
) : Parcelable