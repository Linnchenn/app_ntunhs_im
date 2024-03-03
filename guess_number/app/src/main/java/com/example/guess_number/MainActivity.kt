package com.example.guess_number

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.util.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val Textview = findViewById<TextView>(R.id.Textview)
        val resultView = findViewById<TextView>(R.id.resultview)
        val guess_button = findViewById<Button>(R.id.guess_button)
        val reset_button = findViewById<Button>(R.id.reset_button)
        val editText = findViewById<EditText>(R.id.editText)
        var validate_num: Int
        var minNumber = 1
        var maxNumber = 100
        var secret: Int = Random.nextInt(minNumber , maxNumber + 1)


        guess_button.setOnClickListener {
            val guessedNumber = editText.text.toString().toIntOrNull()

            if (guessedNumber != null) {
                val validateNum = guessedNumber - secret

                val ansStr = when {
                    validateNum > 0 -> {
                        maxNumber = guessedNumber - 1
                        "你猜得比較大喔，範圍在 $minNumber ~ ${guessedNumber - 1}"
                    }
                    validateNum < 0 -> {
                        minNumber = guessedNumber + 1
                        "你猜得比較小喔，範圍在 ${guessedNumber + 1} ~ $maxNumber"
                    }
                    else -> "你猜對了喔"
                }

                Textview.text = ansStr

                if (validateNum == 0) {
                    // 猜對了，重置範圍和隨機數
                    minNumber = 1
                    maxNumber = 100
                    secret = Random.nextInt(minNumber, maxNumber + 1)
                }
            } else {
                Textview.text = "請輸入有效數字"
            }
        }

        reset_button.setOnClickListener {
            // 重置範圍和隨機數
            minNumber = 1
            maxNumber = 100
            secret = Random.nextInt(minNumber, maxNumber + 1)
            Textview.text = "遊戲重置，請猜一個數字"
        }
    }
}
