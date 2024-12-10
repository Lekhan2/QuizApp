package personal.project.quiz_app

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
class QuizQuestion : AppCompatActivity(),View.OnClickListener {

    private var mCurrentPosition:Int=1
    private var mQuestionsList:ArrayList<Question>?=null
    private var mSelectedOption:Int=0

    private var mUsername:String?=null
    private var mCorrectAnswer:Int=0
    

    private var progressBar:ProgressBar?=null
    private var tvProgress:TextView?=null
    private var tvQuestion:TextView?=null
    private var ivImage:ImageView?=null

    private var optionOne:TextView?=null
    private var optionTwo:TextView?=null
    private var optionThree:TextView?=null
    private var optionFour:TextView?=null
    private var btnSubmit:Button?=null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)

        mUsername=intent.getStringExtra(Constant.username)

        progressBar=findViewById(R.id.progressBar)
        tvQuestion=findViewById(R.id.tv_question)
        tvProgress=findViewById(R.id.tv_progress)
        ivImage=findViewById(R.id.imImage)
        optionOne=findViewById(R.id.tv_optionOne)
        optionTwo=findViewById(R.id.tv_optionTow)
        optionThree=findViewById(R.id.tv_optionThree)
        optionFour=findViewById(R.id.tv_optionFour)
        btnSubmit=findViewById(R.id.btn_submit)

        optionOne?.setOnClickListener(this)
        optionTwo?.setOnClickListener(this)
        optionThree?.setOnClickListener(this)
        optionFour ?.setOnClickListener(this)
        btnSubmit?.setOnClickListener(this)
        

        mQuestionsList=Constant.getQuestions()

        setQuestion()
    }

    private fun setQuestion() {
        defaultOptionView()
        val question = mQuestionsList!![mCurrentPosition-1]
        ivImage?.setImageResource(question.image)
        progressBar?.progress = mCurrentPosition
        tvProgress?.text = "${mCurrentPosition }/${progressBar?.max}"
        tvQuestion?.text = question.question
        optionOne?.text = question.Optionone
        optionTwo?.text = question.Optiontwo
        optionThree?.text = question.Optionthree
        optionFour?.text = question.Optionfour

        if(mCurrentPosition==mQuestionsList!!.size){
            btnSubmit?.text="FINISH"
        }
        else{
            btnSubmit?.text="SUBMIT"
        }

    }
    private fun defaultOptionView(){
        val options=ArrayList<TextView>()
        optionOne?.let{
            options.add(0,it)
        }
        optionTwo?.let{
            options.add(1,it)
        }
        optionThree?.let{
            options.add(2,it)
        }
        optionFour?.let{
            options.add(3,it)
        }

        for(option in options){

            option.typeface=Typeface.DEFAULT
            option.background=ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )
        }

    }

    private fun SelectedOptionView(tv:TextView,SelctedOptionNum:Int){
        defaultOptionView()

        mSelectedOption=SelctedOptionNum
        tv.setTextColor(Color.parseColor("#363A46"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background=ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border_bg
        )



    }
    override fun onClick(view: View?) {
        when(view?.id){
            R.id.tv_optionOne->{
                optionOne?.let {
                    SelectedOptionView(it,1)
                }
            }
            R.id.tv_optionTow->{
                optionTwo?.let {
                    SelectedOptionView(it,2)
                }
            }
            R.id.tv_optionThree->{
                optionThree?.let {
                    SelectedOptionView(it,3)
                }
            }
            R.id.tv_optionFour->{
                optionFour?.let {
                    SelectedOptionView(it,4)
                }
            }
            R.id.btn_submit->{
                if(mSelectedOption==0){
                    mCurrentPosition++

                    when{
                        mCurrentPosition<=mQuestionsList!!.size->{
                            setQuestion()
                        }
                        else ->{
                            val intent=Intent(this,ResultActivity::class.java)
                            intent.putExtra(Constant.username,mUsername)
                            intent.putExtra(Constant.Total_Question,mQuestionsList!!.size)
                            intent.putExtra(Constant.Correct_Answers,mCorrectAnswer)
                            startActivity(intent)
                            finish()
                        }
                    }
                }
                else{
                    val question=mQuestionsList?.get(mCurrentPosition-1)
                    if(question!!.CorrectAns!=mSelectedOption){
                        answerView(mSelectedOption,R.drawable.wrong_option_border_bg)
                    }
                    else{
                        mCorrectAnswer+=1
                    }
                    answerView(question.CorrectAns ,R.drawable.correct_option_border_bg)

                    if (mCurrentPosition==mQuestionsList!!.size){
                        btnSubmit?.text="FINISH"

                    }
                    else{
                        btnSubmit?.text="GO TO NEXT QUESTION"
                    }
                    mSelectedOption=0
                }
            }
        }
    }
    private fun answerView(answer:Int,drawableView:Int){
        when(answer){
            1->{
                optionOne?.background=ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            2->{
                optionTwo?.background=ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            3->{
                optionThree?.background=ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            4->{
                optionFour?.background=ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
        }

    }
}