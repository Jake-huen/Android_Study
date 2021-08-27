package com.example.myapplication.android_study

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.myapplication.R

class LibraryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_library)
        val glide:ImageView=findViewById(R.id.glide)
        Glide.with(this@LibraryActivity)
            .load("https://stackoverflow.com/")
            .fitCenter()
            .into(glide)
    }
}