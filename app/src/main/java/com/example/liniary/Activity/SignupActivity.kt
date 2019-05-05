package com.example.liniary.Activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.liniary.R


class SignupActivity : AppCompatActivity() {

    lateinit var age : Spinner
    lateinit var relation1 : Spinner
    lateinit var relation2 : Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_signup)

        age = findViewById<Spinner>(R.id.sp_age)
        relation1 = findViewById<Spinner>(R.id.sp_relation)
        relation2 = findViewById<Spinner>(R.id.sp_relation2)

        val ages = arrayOf("나이","0","1","2","3","4","5","6","7","8","9","10","11","12")
        val relation_1 = arrayOf("관계","엄마","아빠")
        val relation_2 = arrayOf("관계","엄마","아빠")

        age.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,ages)
        relation1.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,relation_1)
        relation2.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,relation_2)
        relation2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            }
        }

        }

    }


