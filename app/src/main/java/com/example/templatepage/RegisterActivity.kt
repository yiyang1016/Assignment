package com.example.loginsignup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import com.example.loginsignup.database.MemberEntity
import com.example.loginsignup.database.UserDB
import com.example.templatepage.R
import kotlinx.android.synthetic.main.register.*
import org.jetbrains.anko.toast
import kotlin.concurrent.thread

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register)

        button3.setOnClickListener(){
            insertData()
        }
        button4.setOnClickListener(){
            clear()
        }
    }

    private fun insertData(){
        var db= Room.databaseBuilder(applicationContext,UserDB::class.java,"MemberDB").allowMainThreadQueries().build()
        var countMember=db.memberDAO().readMemberID()
        var memberIDNum=1000+countMember
        var memberID="M"+memberIDNum
            var member = MemberEntity()
            member.memberId = memberID
            member.memberName = register_name.toString()
            member.memberAddress = register_address.toString()
            member.memberPwd = register_password.toString()

            db.memberDAO().saveMember(member)
        toast("Register successfully!!  Your ID is : "+memberID)
        finish()
    }
    private fun clear(){
        register_name.setText("")
        register_address.setText("")
        register_password.setText("")
    }
}
