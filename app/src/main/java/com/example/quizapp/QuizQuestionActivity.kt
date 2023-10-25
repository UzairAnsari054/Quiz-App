package com.example.quizapp

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

class QuizQuestionActivity : AppCompatActivity(), OnClickListener {

    private var mCurrentPosition = 1
    private var mQuestionList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0

    var progressBar: ProgressBar? = null
    var tvProgress: TextView? = null
    var question: TextView? = null
    var image: ImageView? = null
    var optionOne: TextView? = null
    var optionTwo: TextView? = null
    var optionThree: TextView? = null
    var optionFour: TextView? = null
    var btnSubmit: Button? = null

    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)

        progressBar = findViewById(R.id.progressBar)
        tvProgress = findViewById(R.id.tvProgressBar)
        question = findViewById(R.id.question)
        image = findViewById(R.id.imgFlag)
        optionOne = findViewById(R.id.tv_option_one)
        optionTwo = findViewById(R.id.tv_option_two)
        optionThree = findViewById(R.id.tv_option_three)
        optionFour = findViewById(R.id.tv_option_four)
        btnSubmit = findViewById(R.id.btnSubmit)

        optionOne?.setOnClickListener(this)
        optionTwo?.setOnClickListener(this)
        optionThree?.setOnClickListener(this)
        optionFour?.setOnClickListener(this)

        btnSubmit?.setOnClickListener(this)

        mQuestionList = Constant.getQuestions()


        setQuestion()
    }

    @SuppressLint("SetTextI18n")
    private fun setQuestion() {
        defaultOptionsView()
        var currentQuestion = mQuestionList!![mCurrentPosition - 1]
        image?.setBackgroundResource(currentQuestion.image)
        progressBar?.progress = mCurrentPosition
        tvProgress?.text = "$mCurrentPosition/${progressBar?.max}"
        question?.text = currentQuestion.question
        optionOne?.text = currentQuestion.optionOne
        optionTwo?.text = currentQuestion.optionTwo
        optionThree?.text = currentQuestion.optionThree
        optionFour?.text = currentQuestion.optionFour

        if (mCurrentPosition == mQuestionList!!.size) {
            btnSubmit?.text = "Finish"
        } else {
            btnSubmit?.text = "Submit"
        }
    }

    private fun defaultOptionsView() {
        val options = ArrayList<TextView>()
        optionOne?.let {
            options.add(0, it)
        }
        optionTwo?.let {
            options.add(1, it)
        }
        optionThree?.let {
            options.add(2, it)
        }
        optionFour?.let {
            options.add(3, it)
        }

        for (i in options) {
            i.setTextColor(Color.parseColor("#7A8089"))
            i.typeface = Typeface.DEFAULT
            i.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )
        }
    }

    private fun selectedOptionView(selectedOptionNum: Int, tv: TextView) {
        defaultOptionsView()

        mSelectedOptionPosition = selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border_bg
        )
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.tv_option_one -> optionOne?.let {
                selectedOptionView(1, it)
            }

            R.id.tv_option_two -> optionTwo?.let {
                selectedOptionView(2, it)
            }

            R.id.tv_option_three -> optionThree?.let {
                selectedOptionView(3, it)
            }

            R.id.tv_option_four -> optionFour?.let {
                selectedOptionView(4, it)
            }

            R.id.btnSubmit -> btnSubmit?.let {
                if (mSelectedOptionPosition == 0) {
                    mCurrentPosition++

                    when {
                        mCurrentPosition <= mQuestionList!!.size -> setQuestion()
                        else -> Toast.makeText(this, "Congrats", Toast.LENGTH_LONG).show()
                    }
                } else {
                    val question = mQuestionList?.get(mCurrentPosition - 1)
                    if (question!!.correctAnswer != mSelectedOptionPosition) {
                        answerView(mSelectedOptionPosition , R.drawable.wrong_option_border_bg)
                    }
                    answerView(question.correctAnswer, R.drawable.correct_option_border_bg)

                    if (mCurrentPosition == mQuestionList!!.size) {
                        btnSubmit?.text = "FINISH"
                    } else {
                        btnSubmit?.text = "Go to next question"
                    }

                    mSelectedOptionPosition = 0
                }
            }

        }
    }

    private fun answerView(answer: Int, drawableView: Int) {
        when (answer) {
            1 -> {
                optionOne?.background = ContextCompat.getDrawable(this, drawableView)
            }

            2 -> {
                optionTwo?.background = ContextCompat.getDrawable(this, drawableView)
            }

            3 -> {
                optionThree?.background = ContextCompat.getDrawable(this, drawableView)
            }

            4 -> {
                optionFour?.background = ContextCompat.getDrawable(this, drawableView)
            }

        }
    }
}