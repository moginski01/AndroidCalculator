package com.example.kalkulator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val button1 = findViewById<Button>(R.id.button)
        button1.setOnClickListener{
            val myIntent1 = Intent(this,SimpleCalculator::class.java)
            startActivity(myIntent1)
        }

        val button2 = findViewById<Button>(R.id.button2)
        button2.setOnClickListener{
            val myIntent2 = Intent(this,ProCalculator::class.java)
            startActivity(myIntent2)
        }

        val button3 = findViewById<Button>(R.id.button3)
        button3.setOnClickListener{
            val myIntent3 = Intent(this,About::class.java)
            startActivity(myIntent3)
        }


        val button4 = findViewById<Button>(R.id.button4)
        button4.setOnClickListener {
            finish()
            exitProcess(0);
        }
    }
}