package com.example.a7minuteworkout.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MuscleIntensityModel(
    val lats : Int,
    val abs : Int,
    val obliques : Int

): Parcelable