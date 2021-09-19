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

            val abdominalCrunch = ExerciseModel(2,"abdominal crunch",
                R.drawable.ic_abdominal_crunch,
                false,
                false
            )
            exerciseList.add(abdominalCrunch)

            val highKneesRunningInPlace = ExerciseModel(3,"high knees running in place",
                R.drawable.ic_high_knees_running_in_place,
                false,
                false
            )
            exerciseList.add(highKneesRunningInPlace)

            val plank = ExerciseModel(4,"plank",
                R.drawable.ic_plank,
                false,
                false
            )
            exerciseList.add(plank)

            val pushUp = ExerciseModel(5,"push up",
                R.drawable.ic_push_up,
                false,
                false
            )
            exerciseList.add(pushUp)

            val lunge = ExerciseModel(6,"lunge",
                R.drawable.ic_lunge,
                false,
                false
            )
            exerciseList.add(lunge)






            return exerciseList

        }
    }
}