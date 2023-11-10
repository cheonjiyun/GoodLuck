package com.juna.goodluck

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView

class LastActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_last)

        /* 상단바 */
        setSupportActionBar(findViewById(R.id.toolbar))
        getSupportActionBar()!!.setTitle("")

        findViewById<ImageView>(R.id.toolbar_back).setOnClickListener {
            finish()
        }

        findViewById<TextView>(R.id.current_title).setText(R.string.last_luck)




    }

}