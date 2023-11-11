package com.juna.goodluck

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toolbar
import androidx.room.Room
import androidx.room.RoomDatabase
import com.wajahatkarim3.easyflipview.EasyFlipView
import java.io.BufferedReader
import java.io.File
import java.io.IOException
import java.io.InputStreamReader
import java.lang.StringBuilder
import kotlin.random.Random
import java.time.LocalDate

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(findViewById(R.id.toolbar))


        Log.d("주기체크", "onCreate 켜짐")

        /* 글귀 선정 */
        // 파일 읽기
        val luckTextAll = mutableListOf<String>()
        try{
            val inputStream = resources.openRawResource(R.raw.luck_text)

            //Log.d("텍스트", "${inputStream.read()}")

            val reader = BufferedReader(InputStreamReader(inputStream, "UTF-8"))

            var line : String?
            do{
                line = reader.readLine()
                if( line != null){
                    luckTextAll.add(line)
                }
            }while (line != null)
            reader.close()

            for (i in luckTextAll){
                Log.d("텍스트2", i)
            }

        }catch (e: IOException){
            e.printStackTrace()
        }

        //랜덤
        val random1 = Random.nextInt(0,luckTextAll.size)
        val random2 = Random.nextInt(0,luckTextAll.size)
        val random3 = Random.nextInt(0,luckTextAll.size)

        //뽑기
        var luckText = listOf(luckTextAll[random1], luckTextAll[random2], luckTextAll[random3])
        Log.d("랜덤글귀", "${luckTextAll[random1]}, ${luckTextAll[random2]}, ${luckTextAll[random3]}")


        var card1 = findViewById<EasyFlipView>(R.id.card1)
        var card2 = findViewById<EasyFlipView>(R.id.card2)
        var card3 = findViewById<EasyFlipView>(R.id.card3)
        var luckTextView = findViewById<TextView>(R.id.luckText)

        /* 오늘 날짜 */
        var todaydateTextView = findViewById<TextView>(R.id.todayDate)
        todaydateTextView.setText("${LocalDate.now()}")


//        /* 카드 정보 저장 변수 */
//        val cardShared: SharedPreferences = applicationContext.getSharedPreferences(
//            "cardNumberInfo",
//            Context.MODE_PRIVATE
//        )
//        var cardNumber = cardShared.getInt("cardNumber", 0)
//        var cardDate =  cardShared.getString("cardDate", "")
//        Log.d("카드 정보", "${cardNumber} ${cardDate} 앞뒤:${card2.currentFlipState}")
//        if(cardDate == LocalDate.now().toString() && cardNumber != 0){ // 오늘 안했다면 && 선택이 이루어졌다면
//            //카드 못 뒤집게 함
//            card1.setFlipEnabled(false)
//            card2.setFlipEnabled(false)
//            card3.setFlipEnabled(false)
//
//            when(cardNumber){
//                1 -> {
//                    card1.performClick()
//                }
//                2 -> {
//                    Log.d("카드", "when문 들어옴")
//                    card2.FlipState.BACK_SIDE
//                }
//                3 -> {
//                    card3.performClick()
//                }
//            }
//        }

        /* 카드 뒤집으면 */
        card1.setOnFlipListener { easyFlipView, newCurrentSide ->
            //다른 카드 못 뒤집게 함
            card2.setFlipEnabled(false)
            card3.setFlipEnabled(false)

            //글귀 보이게
            luckTextView.setText(luckText[0])

            //몇번째 카드를 뒤집었는지 정보 저장
            with(cardShared.edit()){
                putInt("cardNumber", 1)
                putString("cardDate", LocalDate.now().toString())
                apply()
            }
        }

        card2.setOnFlipListener { easyFlipView, newCurrentSide ->
            //다른 카드 못 뒤집게 함
            card1.setFlipEnabled(false)
            card3.setFlipEnabled(false)

            //글귀 보이게
            luckTextView.setText(luckText[1])

            //몇번째 카드를 뒤집었는지 정보 저장
            with(cardShared.edit()){
                putInt("cardNumber", 2)
                putString("cardDate", LocalDate.now().toString())
                apply()
            }
        }

        card3.setOnFlipListener { easyFlipView, newCurrentSide ->
            //다른 카드 못 뒤집게 함
            card1.setFlipEnabled(false)
            card2.setFlipEnabled(false)

            //글귀 보이게
            luckTextView.setText(luckText[2])

            //몇번째 카드를 뒤집었는지 정보 저장
            with(cardShared.edit()){
                putInt("cardNumber", 3)
                putString("cardDate", LocalDate.now().toString())
                apply()
            }
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
