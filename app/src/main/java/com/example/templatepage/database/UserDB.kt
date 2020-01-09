package com.example.loginsignup.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [MemberEntity::class],version = 1)
abstract class UserDB :  RoomDatabase(){
    abstract fun memberDAO():MemberDAO
}