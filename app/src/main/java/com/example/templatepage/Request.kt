package com.example.templatepage

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Request(
    @PrimaryKey(autoGenerate = true)
    var  id: Int = 0,

    @ColumnInfo(name = "address")
    var address: String = "",

    @ColumnInfo(name = "no")
    var no: String = "",

    @ColumnInfo(name = "date")
    var date: String = ""
)
