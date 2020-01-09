package com.example.loginsignup.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CollectorDAO {
    @Insert
    fun saveCollector(collector : CollectorEntity)

    @Query("select * from collector where collectorId=:id and collectorPwd=:password")
    fun loginCollector(id: String, password:String): CollectorEntity
}