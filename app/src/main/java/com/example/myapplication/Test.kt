package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView

class Test : AppCompatActivity() {
    var number:Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        val zero:TextView=findViewById(R.id.zero)
        val one:TextView=findViewById(R.id.one)
        val two:TextView=findViewById(R.id.two)
        val three:TextView=findViewById(R.id.three)
        val four:TextView=findViewById(R.id.four)
        val five:TextView=findViewById(R.id.five)
        val six:TextView=findViewById(R.id.six)
        val seven:TextView=findViewById(R.id.seven)
        val eight:TextView=findViewById(R.id.eight)
        val nine:TextView=findViewById(R.id.nine)
        val CA:TextView=findViewById(R.id.CA)
        val plus:TextView=findViewById(R.id.plus)
        val result:EditText=findViewById(R.id.result)

        one.setOnClickListener {
            result.setText(""+1)
            if(plus.hasOnClickListeners()){
                number+=1
                result.setText(number)
            }
        }
    }
}