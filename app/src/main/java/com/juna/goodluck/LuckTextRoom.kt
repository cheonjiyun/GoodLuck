package com.juna.goodluck

import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.RoomDatabase

//@Database(entities = [LuckText::class], version = 1)
//abstract class LuckTextDatabase : RoomDatabase(){
//    abstract fun LuckTextDao(): LuckTextDao
//}



//// 운세글귀전체
//@Dao
//interface LuckTextDao {
//
//    @Insert
//    fun luckTextInsert(id: Int, luck_text: String)
//
//    @Query("SELECT luck_text FROM luck_text")
//    fun luckTextView() : List<String>
//}
//
//
//@Entity(tableName = "luck_text")
//class LuckText (
//    @PrimaryKey val id: Int,
//    @ColumnInfo(name = "luck_text")
//    val luckText: String
//)


////내 지난 운세
//@Dao
//interface UserLastLuckDao{
//    @Insert
//    fun lastLuckInsert(date: String, card_number: Int, text: String)
//
//    @Query("SELECT id FROM user_last_luck")
//    fun lastLuckView() : List<Int>
//}
//
//@Entity(tableName = "user_last_luck",
//    foreignKeys = [
//        ForeignKey(
//            entity = LuckText::class,
//            parentColumns = ["id"],
//            childColumns = ["id"],
//            onDelete = ForeignKey.CASCADE,
//            onUpdate = ForeignKey.CASCADE,
//        )
//    ]
//
//)
//class UserLastLuck(
//    @PrimaryKey val index: Int,
//    val date: String,
//    @ColumnInfo(name = "card_number")
//    val cardNumber: Int,
//    val id: Int
//
//)
//
//data class LastLuck(
//    val index: Int,
//    val date: String,
//    val cardNumber: Int,
//    val id: Int
//)