package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class PhoneBookDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_book_detail)
        getPersonInfoDraw()
        val back:ImageView=findViewById(R.id.back)
        back.setOnClickListener{
            onBackPressed()
        }
    }

    fun getPersonInfoDraw(){
        val name = intent.getStringExtra("name")
        val number = intent.getStringExtra("number")

        val person_detail_name:TextView = findViewById(R.id.persone_detail_name)
        val person_detail_number:TextView = findViewById(R.id.persone_detail_number)
        person_detail_name.setText(name)
        person_detail_number.setText(number)
    }
}