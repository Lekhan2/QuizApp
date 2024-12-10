package personal.project.quiz_app

object Constant {

    const val username:String="user_name"
    const val Total_Question:String="total_question"
    const val Correct_Answers:String="correct_answers"


    fun getQuestions():ArrayList<Question>{
         val questionList=ArrayList<Question>()

        val q1=Question(
            1,"What country does the flag belongs to?",R.drawable.india_flag,"India","Pakistan",
            "Iran","England",1
        )
        questionList.add(q1)
        val q2=Question(
            1,"What country does the flag belongs to?",R.drawable.india_flag,"Pakistan","India",
            "Iran","England",2
        )
        questionList.add(q2)
        val q3=Question(
            1,"What country does the flag belongs to?",R.drawable.india_flag,"India","Pakistan",
            "Iran","England",1
        )
        questionList.add(q3)
        val q4=Question(
            1,"What country does the flag belongs to?",R.drawable.india_flag,"England","Pakistan",
            "Iran","India",4
        )
        questionList.add(q4)
        val q5=Question(
            1,"What country does the flag belongs to?",R.drawable.india_flag,"Iran","Pakistan",
            "India","England",3
        )
        questionList.add(q5)
        val q6=Question(
            1,"What country does the flag belongs to?",R.drawable.india_flag,"India","Pakistan",
            "Iran","England",1
        )
        questionList.add(q6)
        val q7=Question(
            1,"What country does the flag belongs to?",R.drawable.india_flag,"India","Pakistan",
            "Iran","England",1
        )
        questionList.add(q7)
        val q8=Question(
            1,"What country does the flag belongs to?",R.drawable.india_flag,"England","Pakistan",
            "Iran","India",4
        )
        questionList.add(q8)

        return questionList
    }
}