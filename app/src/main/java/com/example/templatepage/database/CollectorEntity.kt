package com.example.loginsignup.database

import androidx.room.*

@Entity(tableName = "Collector")
data class CollectorEntity (
    @PrimaryKey
    //@NonNull
    @ColumnInfo(name = "collectorId")
    var collectorId: String="" ,
    @ColumnInfo(name="collectorName")
    var collectorName: String="" ,
    @ColumnInfo(name="collectorPwd")
    var collectorPwd:String=""
)