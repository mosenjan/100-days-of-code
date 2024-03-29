package com.example.a7minuteworkout.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class CategoryModel (
    val cardio : Int,
    val plyometric : Int,
    val lower_body : Int,
    val upper_body : Int,
    val shoulder_and_back : Int,
    val core : Int,
    val stretching : Int,
    val yoga : Int,
    val balance : Int,
    val warmup : Int): Parcelable