package com.juna.goodluck

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toolbar
import com.wajahatkarim3.easyflipview.EasyFlipView
import kotlin.random.Random
import java.time.LocalDate

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(findViewById(R.id.toolbar))




        var luckTextAll = arrayOf("별로에요", "끌세요", "안좋아요", "그냥그래요", "짱이에요", "날아갈거같아요", "끝내줘요")

        val random1 = Random.nextInt(0,7)
        val random2 = Random.nextInt(0,7)
        val random3 = Random.nextInt(0,7)


        // 글귀 선정
        var luckText = arrayOf(luckTextAll[random1], luckTextAll[random2], luckTextAll[random3])
        Log.d("랜덤글귀", "${luckTextAll[random1]}, ${luckTextAll[random2]}, ${luckTextAll[random3]}")



        var card1 = findViewById<EasyFlipView>(R.id.card1)
        var card2 = findViewById<EasyFlipView>(R.id.card2)
        var card3 = findViewById<EasyFlipView>(R.id.card3)
        var luckTextView = findViewById<TextView>(R.id.luckText)

        // 오늘 날짜
        var todaydateTextView = findViewById<TextView>(R.id.todayDate)
        todaydateTextView.setText("${LocalDate.now()}")

        // 뒤집기
        card1.setOnFlipListener { easyFlipView, newCurrentSide ->
            //다른 카드 못 뒤집게 함
            card2.setFlipEnabled(false)
            card3.setFlipEnabled(false)

            luckTextView.setText(luckText[0])
        }

        card2.setOnFlipListener { easyFlipView, newCurrentSide ->
            //다른 카드 못 뒤집게 함
            card1.setFlipEnabled(false)
            card3.setFlipEnabled(false)

            luckTextView.setText(luckText[1])
        }

        card3.setOnFlipListener { easyFlipView, newCurrentSide ->
            //다른 카드 못 뒤집게 함
            card1.setFlipEnabled(false)
            card2.setFlipEnabled(false)

            luckTextView.setText(luckText[2])
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.top_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.lastLuckButton -> {
                val intent = Intent(this, LastActivity::class.java)
                startActivity(intent)
            }

            R.id.settingButton -> {
                val intent = Intent(this, SettingActivity::class.java)
                startActivity(intent)
            }

        }
        return super.onOptionsItemSelected(item)
    }
}