package com.example.myapplication.android_study

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.myapplication.R

class Test2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test2)

        val internet_edit:EditText=findViewById(R.id.internet_edit)
        val internet_button:Button=findViewById(R.id.internet_button)

        internet_button.setOnClickListener{
            val str:String=internet_edit.toString()
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(str))
            startActivity(intent)
        }
    }
}