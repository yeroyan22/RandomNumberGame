package com.example.randomnumbergame


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var easy: Button
    private lateinit var medium: Button
    private lateinit var hard: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        easy = findViewById(R.id.easy)
        medium = findViewById(R.id.medium)
        hard = findViewById(R.id.hard)

        easy.setOnClickListener() {
            intent = Intent(this, GameActivity::class.java)
            intent.putExtra(ENTRY_COUNT, 7)
            startActivity(intent)
        }

        medium.setOnClickListener() {
            intent = Intent(this, GameActivity::class.java)
            intent.putExtra(ENTRY_COUNT, 5)
            startActivity(intent)
        }

        hard.setOnClickListener() {
            intent = Intent(this, GameActivity::class.java)
            intent.putExtra(ENTRY_COUNT,3)
            startActivity(intent)
        }
    }
    companion object{
        const val ENTRY_COUNT: String = "entry_count"
    }
}


