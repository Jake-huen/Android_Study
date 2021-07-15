package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.LinearLayout

class DiaryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diary)
    }
    fun fakeMemoryList(fakeNumber:Int = 10,memory:Memory=Memory()):Memory{
        val place=arrayOf("잠실","강남","회기","대구","부산","매봉","송파나루","잠실나루","인사동","건대")
        for(i in 0 until fakeNumber){
            memory.add_memory(OneMemory(""+place.get(i),20210306))
        }
        return memory
    }

    fun createMemoryList(memory: Memory){
        val layoutInflater=LayoutInflater.from(this@DiaryActivity)
        val container = findViewById<LinearLayout>(R.id.diary_list_container)
        for(i in 0 until )
    }
}

class Memory(){
    val memoryList=ArrayList<OneMemory>()
    fun add_memory(onememory:OneMemory){
        memoryList.add(onememory)
    }
}

class OneMemory(val place:String,val date:Int){

}