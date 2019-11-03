package com.example.android.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    lateinit var diceImage1 : ImageView
    lateinit var diceImage2 : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        diceImage1 = findViewById(R.id.dice_image1)
        diceImage2 = findViewById(R.id.dice_image2)

        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener { rollDice() }

        /*val countUpButton: Button = findViewById(R.id.countUp_button)
        countUpButton.setOnClickListener { countUp() }*/
    }

    private fun rollDice() {
        //Toast.makeText(this, "button clicked", Toast.LENGTH_SHORT).show()
        val first = getRandomDiceImage()
        var second = getRandomDiceImage()
        while(second == first) {
             second = getRandomDiceImage()
        }
        val drawableResourceFirst = when (first) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        val drawableResourceSecond = when (second) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage1.setImageResource(drawableResourceFirst)
        diceImage2.setImageResource(drawableResourceSecond)
    }

    private fun getRandomDiceImage() : Int {
        val randomInt = Random.nextInt(6) + 1
        return randomInt
    }

    /*private fun countUp() {
        val resultText: TextView = findViewById(R.id.result_text)
        if (resultText.text == "Hello World!") {
            resultText.text = 1.toString()
        }
        else if (resultText.text != "6") {
            val result = resultText.text.toString()
            resultText.text = (Integer.parseInt(result) + 1).toString()
        }
    }*/
}
