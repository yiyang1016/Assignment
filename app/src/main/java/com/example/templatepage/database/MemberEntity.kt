package com.example.loginsignup.database

import androidx.annotation.NonNull
import androidx.room.*



@Entity(tableName = "Member")
data class MemberEntity (
    @PrimaryKey
    //@NonNull
    @ColumnInfo(name = "memberId")
    var memberId: String=" " ,
    @ColumnInfo(name="memberName")
    var memberName: String=" " ,
    @ColumnInfo(name="memberAddress")
    var memberAddress:String=" ",
    @ColumnInfo(name="memberPwd")
    var memberPwd:String=" "
)