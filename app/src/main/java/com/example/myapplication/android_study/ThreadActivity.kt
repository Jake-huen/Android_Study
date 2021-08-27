package com.example.myapplication.android_study

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.example.myapplication.R

class ThreadActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thread)

        val runnable:Runnable=object:Runnable{
            override fun run(){
                Log.d("thread-1","Thread1 is made")
            }
        }
        val thread : Thread=Thread(runnable)
        val button:Button=findViewById(R.id.button22)
        button.setOnClickListener {
            thread.start()
        }

        Thread(object:Runnable{
            override fun run(){
                Log.d("thread-1","Thread2 is made")
            }
        }).start()

        Thread(Runnable{
            Thread.sleep(2000)
            Log.d("thread-1","Thread3 is made")
            runOnUiThread{
                button.setBackgroundColor(getColor(R.color.textview_color))
            }
        }).start()


    }
}