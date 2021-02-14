package com.example.quizapp

object Constants{

    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTION: String = "total_question"
    const val CORRECT_ANSWERS: String = "correct_answers"


    fun getQuestions():ArrayList<Question>{

        var questionList = ArrayList<Question>()

        val que1 = Question(1,
            "چرا در شمال ایران سقف ها شیبدار هستند؟",
            R.drawable.ic_flag_of_argentina,
            "شیب",
            "شیب دار",
            "سقف",
            "ایران",
            2
        )
        questionList.add(que1)

        val que2 = Question(2,
            "چرا در شمال ایران سقف ها شیبدار هستند؟",
            R.drawable.ic_flag_of_australia,
            "شیب",
            "شیب دار",
            "سقف",
            "ایران",
            2
        )
        questionList.add(que2)

        val que3 = Question(3,
            "چرا در شمال ایران سقف ها شیبدار هستند؟",
            R.drawable.ic_flag_of_belgium,
            "شیب",
            "شیب دار",
            "سقف",
            "ایران",
            2
        )
        questionList.add(que3)

        val que4 = Question(4,
            "چرا در شمال ایران سقف ها شیبدار هستند؟",
            R.drawable.ic_flag_of_brazil,
            "شیب",
            "شیب دار",
            "سقف",
            "ایران",
            2
        )
        questionList.add(que4)

        val que5 = Question(5,
            "چرا در شمال ایران سقف ها شیبدار هستند؟",
            R.drawable.ic_flag_of_denmark,
            "شیب",
            "شیب دار",
            "سقف",
            "ایران",
            2
        )
        questionList.add(que5)

        val que6 = Question(6,
            "چرا در شمال ایران سقف ها شیبدار هستند؟",
            R.drawable.ic_flag_of_fiji,
            "شیب",
            "شیب دار",
            "سقف",
            "ایران",
            2
        )
        questionList.add(que6)

        val que7 = Question(7,
            "چرا در شمال ایران سقف ها شیبدار هستند؟",
            R.drawable.ic_flag_of_germany,
            "شیب",
            "شیب دار",
            "سقف",
            "ایران",
            2
        )
        questionList.add(que7)

        val que8 = Question(8,
            "چرا در شمال ایران سقف ها شیبدار هستند؟",
            R.drawable.ic_flag_of_india,
            "شیب",
            "شیب دار",
            "سقف",
            "ایران",
            2
        )
        questionList.add(que8)

        val que9 = Question(9,
            "چرا در شمال ایران سقف ها شیبدار هستند؟",
            R.drawable.ic_flag_of_kuwait,
            "شیب",
            "شیب دار",
            "سقف",
            "ایران",
            2
        )
        questionList.add(que9)

        val que10 = Question(10,
            "چرا در شمال ایران سقف ها شیبدار هستند؟",
            R.drawable.ic_flag_of_new_zealand,
            "شیب",
            "شیب دار",
            "سقف",
            "ایران",
            2
        )
        questionList.add(que10)



        return questionList
    }
}