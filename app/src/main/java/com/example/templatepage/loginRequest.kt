package com.example.loginsignup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.room.Room
import com.example.loginsignup.database.CollectorDB
import com.example.loginsignup.database.CollectorEntity
import com.example.loginsignup.database.MemberEntity
import com.example.loginsignup.database.UserDB
import com.example.templatepage.R
import kotlinx.android.synthetic.main.login.*
import kotlinx.android.synthetic.main.register.*
import org.jetbrains.anko.toast

class loginRequest : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)
        insertCollector()
        button2.setOnClickListener(){
            val intent= Intent(this,RegisterActivity::class.java)
            startActivity(intent)
        }
        button.setOnClickListener(){
            loginClickedFunction()
        }
    }

    private fun  loginClickedFunction() {
        var loginID:String = login_id.toString()
        val loginPassword:String = login_password.toString()
        var firstChar: Char = loginID[0]
        //CANNOT
        when (firstChar) {
            'M' -> {
                var db = Room.databaseBuilder(applicationContext, UserDB::class.java, "MemberDB")
                    .allowMainThreadQueries().build()
                var memberInformation = db.memberDAO().loginMember(loginID, loginPassword)
                if(memberInformation!=null)
                    toast("SUCCESS")
                else
                    toast("ERROR")
            }
            'C' -> {
                var db =
                    Room.databaseBuilder(applicationContext, CollectorDB::class.java, "CollectorDB")
                        .allowMainThreadQueries().build()
                var collectorInformation = db.collectorDAO().loginCollector(loginID, loginPassword)
                if(collectorInformation!=null)
                    toast(collectorInformation.toString())
            }
        }
    }

    /*private fun  loginClickedFunction(){
            val loginID=login_id.toString()
            val loginPassword=login_password.toString()
        var db= Room.databaseBuilder(applicationContext, UserDB::class.java,"MemberDB").allowMainThreadQueries().build()

        //see you guys wanna get member name or not...
        var  memberName=db.memberDAO().loginMember(loginID,loginPassword)
    }*/

    private fun insertCollector(){
        var db= Room.databaseBuilder(applicationContext, CollectorDB::class.java,"CollectorDB").allowMainThreadQueries().build()
        Thread{
            var collector= CollectorEntity()
            collector.collectorId="C1001"
            collector.collectorName="Ahmand"
            collector.collectorPwd="ased12345"
            db.collectorDAO().saveCollector(collector)
        }.start()
    }

}
