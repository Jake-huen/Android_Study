package com.example.myapplication.android_study

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.R

class Context : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_context)

        val context : Context =this
        //자식은 부모의 타입이 될 수 있다
        val applicationContext : Context =getApplicationContext() as Context

    }
}