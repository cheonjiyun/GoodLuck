package com.juna.goodluck

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class SettingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        /* 상단바 */
        setSupportActionBar(findViewById(R.id.toolbar))
        getSupportActionBar()!!.setTitle("")

        findViewById<ImageView>(R.id.toolbar_back).setOnClickListener {
            finish()
        }

        findViewById<TextView>(R.id.current_title).setText(R.string.setting)


    }
}