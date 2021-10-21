package com.example.a7minuteworkout.models

import Sets
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

data class ExercisesModel(
    val exercises: ArrayList<Exercises>
)

@Parcelize
data class Exercises (
    val code : String,
    val title : String,
    val category : CategoryModel,
    val stance : String,
    val skill_required : Int,
    val skill_max : Int,
    val sexyness : Int,
    val looks_cool : Int,
    val impact : Int,
    val noisy : Int,
    val change_sides : Boolean,
    val sets :@RawValue Sets,
    val constraint_positive : String,
    val constraint_negative : String,
    val duration : Int,
    val reps : Int,
    val reps_double : Boolean,
    val reps_count_times : List<String>,
    val reps_hint : String,
    val tool : String,
    val muscle_intensity : MuscleIntensityModel,
    val instructions : InstructionsModel
    ): Parcelable