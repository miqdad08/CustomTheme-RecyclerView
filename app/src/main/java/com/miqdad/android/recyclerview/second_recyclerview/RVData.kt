package com.miqdad.android.recyclerview.second_recyclerview

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RVData(
    var textData : String,
    var imgData : String
):Parcelable