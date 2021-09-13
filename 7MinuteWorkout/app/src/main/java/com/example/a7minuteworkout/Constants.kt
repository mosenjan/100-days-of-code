package com.example.a7minuteworkout

class Constants {
    companion object{
        fun defaultExerciseList():ArrayList<ExerciseModel>{
            val exerciseList = ArrayList<ExerciseModel>()

            val jumpingJacks = ExerciseModel(1,"jumpingJacks",
                R.drawable.ic_jumping_jacks,
                false,
                false
            )
            exerciseList.add(jumpingJacks)






            return exerciseList

        }
    }
}