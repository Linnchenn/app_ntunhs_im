package com.example.a0321

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import kotlin.random.Random as Random

class MainActivity : AppCompatActivity() {
    private lateinit var txtCom :TextView
    private lateinit var txtResult :TextView
    private lateinit var imbtnScissor :ImageButton
    private lateinit var imbtnRock : ImageButton
    private lateinit var imbtnPaper : ImageButton
    private lateinit var imageView: ImageView

    enum class Choice{
        SCISSORS, ROCK, PAPER
    }

    fun playGame(playerChoice: Choice){
        val choices = Choice.values()
        var computerChoice = choices[Random.nextInt(choices.size)]

        when (computerChoice) {
            Choice.SCISSORS -> imageView.setImageResource(R.drawable.scissors)
            Choice.PAPER -> imageView.setImageResource(R.drawable.paper)
            Choice.ROCK -> imageView.setImageResource(R.drawable.rock)
        }

        when {
            playerChoice == computerChoice -> {
                txtCom.setText(getChoiceString(computerChoice))
                txtResult.setText(R.string.draw)
            }
            (playerChoice == Choice.SCISSORS && computerChoice == Choice.PAPER) ||
                    (playerChoice == Choice.ROCK && computerChoice == Choice.SCISSORS) ||
                    (playerChoice == Choice.PAPER && computerChoice == Choice.ROCK)->{
                 txtCom.setText(getChoiceString(computerChoice))
                 txtResult.setText(R.string.win)
            }
            else ->{
                txtCom.setText(getChoiceString(computerChoice))
                txtResult.setText(R.string.lose)
            }
        }
    }

    private fun getChoiceString(choice: Choice): Int{
        return when(choice){
            Choice.SCISSORS -> R.string.scissors
            Choice.ROCK -> R.string.rock
            Choice.PAPER -> R.string.paper
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtCom = findViewById(R.id.txtCom)
        txtResult = findViewById(R.id.txtResult)
        imbtnScissor = findViewById(R.id.imbtnScissor)
        imbtnRock = findViewById(R.id.imbtnRock)
        imbtnPaper = findViewById(R.id.imbtnPaper)
        imageView = findViewById(R.id.imageView)

        imbtnScissor.setOnClickListener{
            playGame(Choice.SCISSORS)
        }
        imbtnRock.setOnClickListener {
            playGame(Choice.ROCK)
        }
        imbtnPaper.setOnClickListener{
            playGame(Choice.PAPER)
        }
    }
}