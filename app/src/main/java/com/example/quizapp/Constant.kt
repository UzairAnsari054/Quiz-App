package com.example.quizapp

object Constant {

    fun getQuestions(): ArrayList<Question> {
        val questionList = ArrayList<Question>()

        val question1 = Question(
            1, "What country does this flag belongs to ?",
            R.drawable.ic_flag_of_argentina,
            "Argentina", "India",
            "Denmark", "Kuwait",
            1
        )
        questionList.add(question1)

        val question2 = Question(
            2, "What country does this flag belongs to ?",
            R.drawable.ic_flag_of_australia,
            "Argentina", "Australia",
            "Denmark", "Kuwait",
            2
        )
        questionList.add(question2)

        val question3 = Question(
            3, "What country does this flag belongs to ?",
            R.drawable.ic_flag_of_belgium,
            "Belgium", "India",
            "Denmark", "Kuwait",
            1
        )
        questionList.add(question3)

        val question4 = Question(
            4, "What country does this flag belongs to ?",
            R.drawable.ic_flag_of_brazil,
            "Argentina", "India",
            "Denmark", "Brazil",
            4
        )
        questionList.add(question4)

        val question5 = Question(
            5, "What country does this flag belongs to ?",
            R.drawable.ic_flag_of_denmark,
            "Argentina", "India",
            "Denmark", "Kuwait",
            3
        )
        questionList.add(question5)

        val question6 = Question(
            6, "What country does this flag belongs to ?",
            R.drawable.ic_flag_of_fiji,
            "Argentina", "Fiji",
            "Denmark", "Kuwait",
            2
        )
        questionList.add(question6)

        val question7 = Question(
            7, "What country does this flag belongs to ?",
            R.drawable.ic_flag_of_germany,
            "Argentina", "India",
            "Germany", "Kuwait",
            3
        )
        questionList.add(question7)

        val question8 = Question(
            8, "What country does this flag belongs to ?",
            R.drawable.ic_flag_of_india,
            "Argentina", "India",
            "Denmark", "Kuwait",
            2
        )
        questionList.add(question8)

        val question9 = Question(
            9, "What country does this flag belongs to ?",
            R.drawable.ic_flag_of_kuwait,
            "Argentina", "India",
            "Denmark", "Kuwait",
            4
        )
        questionList.add(question9)

        val question10 = Question(
            1, "What country does this flag belongs to ?",
            R.drawable.ic_flag_of_new_zealand,
            "New Zealand", "India",
            "Denmark", "Kuwait",
            1
        )
        questionList.add(question10)

        return questionList
    }
}