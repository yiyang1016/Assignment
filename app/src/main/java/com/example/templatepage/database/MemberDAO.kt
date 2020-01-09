package com.example.loginsignup.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MemberDAO {
    @Insert
    fun saveMember(member : MemberEntity)

    @Query("select count(*) as numberOfMember from member")
    fun readMemberID():Int

    @Query("select * from member where memberId=:id and memberPwd=:password")
    fun loginMember(id: String, password:String): MemberEntity
}