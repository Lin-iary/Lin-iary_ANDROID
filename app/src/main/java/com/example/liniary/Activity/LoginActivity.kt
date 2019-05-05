package com.example.liniary.Activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.liniary.R
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnMainLogin.setOnClickListener {
            val intent :Intent= Intent(this,ContentActivity::class.java)
            startActivity(intent)
        }
        btnMainSignup.setOnClickListener {
            val intent: Intent = Intent(this,SignupActivity::class.java)
            startActivity(intent)
        }


    }
}
