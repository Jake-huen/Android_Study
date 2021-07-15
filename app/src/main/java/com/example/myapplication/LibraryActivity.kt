package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide

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