package com.juna.goodluck

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)


        val card2 = findViewById<ImageView>(R.id.card2)
        var luckText = findViewById<TextView>(R.id.luckText)
        card2.setOnClickListener {
            luckText.visibility = View.VISIBLE
        }
    }
}