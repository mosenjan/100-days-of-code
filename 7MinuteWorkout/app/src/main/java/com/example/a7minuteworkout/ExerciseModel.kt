package com.example.a7minuteworkout

data class ExerciseModel (
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
    val sets : String,
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
    ) {

    fun getId():String{
        return code

    }

    fun getName():String{
        return title

    }



}