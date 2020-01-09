package com.example.loginsignup.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [CollectorEntity::class],version = 1)
abstract class CollectorDB :  RoomDatabase(){
    abstract fun collectorDAO():CollectorDAO
}