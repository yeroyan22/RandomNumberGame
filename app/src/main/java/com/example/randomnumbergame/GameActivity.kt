package com.example.randomnumbergame

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.*
import androidx.core.view.isVisible

class GameActivity : AppCompatActivity() {

    private lateinit var input: EditText
    private lateinit var enter: Button
    private lateinit var entiesText: TextView
    private lateinit var message: TextView
    private lateinit var restart: Button

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        input = findViewById(R.id.editText)
        enter = findViewById(R.id.button)
        entiesText = findViewById(R.id.enties)
        message = findViewById(R.id.textView)
        restart = findViewById(R.id.restart)

        var num = (0..100).random()
        println("Random number is $num")
        var entries = intent.getIntExtra(MainActivity.ENTRY_COUNT, 0)
        entiesText.text = "$entries entries left"
        restart.isVisible = false



        enter.setOnClickListener() {
            if (input.text.isEmpty()) {
                makeText(applicationContext, "You need to enter a number", LENGTH_LONG)
                    .show()
                return@setOnClickListener
            }
            entries--
            entiesText.text = "$entries entries left"
            if (entries < 1) {
                message.text = "You lost :( Start Over!"
                entiesText.text = null
                enter.isVisible = false
                restart.isVisible = true
                return@setOnClickListener
            }
            var guess = input.text.toString().toInt()
            if (guess == num) {
                message.text = "You won!!!"
                entiesText.text = null
                enter.isVisible = false
                restart.isVisible = true
            } else if (guess < num) {
                message.text = "Take higher!"
            } else {
                message.text = "Take lower!"
            }
        }

        restart.setOnClickListener() {
            recreate()
            input.text.clear()
        }
    }
}
