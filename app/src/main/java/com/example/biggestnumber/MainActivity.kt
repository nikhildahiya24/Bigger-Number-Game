package com.example.biggestnumber

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var btnLeft:Button
    private lateinit var btnright:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnLeft=findViewById(R.id.btnLeft)
        btnright=findViewById(R.id.btnright)
        assignNumbersToButtons()
        btnLeft.setOnClickListener {
            // Code here will run everytime left button is clicked
             // 1. compare the numbers in the boxes

                checkAnswer(true)
            assignNumbersToButtons()
        }

        btnright.setOnClickListener{
            checkAnswer(false)

            assignNumbersToButtons()
        }
    }
        private fun checkAnswer(isLeftButtonSelected: Boolean){
            val leftNum = btnLeft.text.toString().toInt()
            val rightNum = btnright.text.toString().toInt()
            val isAnswerCorrect: Boolean = if(isLeftButtonSelected) leftNum > rightNum else rightNum > leftNum
            if(isAnswerCorrect){
                // correct answer!!
                //Change background colour
                backgroundView.setBackgroundColor(Color.GREEN)
                // Show a Toast
                Toast.makeText(this, "Correct", Toast.LENGTH_SHORT ).show()

            }
            else{

                backgroundView.setBackgroundColor(Color.RED)
                Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT ).show()
            }
        }
    private fun assignNumbersToButtons() {
       val r = Random()
        val leftNum = r.nextInt(10)
        var rightNum = leftNum
        while (rightNum == leftNum){
            rightNum= r.nextInt(10)
        }

        btnLeft.text = leftNum.toString()
        btnright.text = rightNum.toString()
    }
}