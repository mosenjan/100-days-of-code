package com.example.a7minuteworkout.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class InstructionsModel(
    val hints : List<String>,
    val breathing : List<String>,
    val harder : List<String>,
    val easier : List<String>
): Parcelable