package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView


class Listener : AppCompatActivity() {
    var number = 10

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listener)

        // 뷰를 activity로 가져오는 방법
        // 1> 직접 찾아서 가져온다
        val textView:TextView=findViewById(R.id.hello)
        val image:ImageView=findViewById(R.id.image)
        val editText:EditText=findViewById(R.id.editText)
        // 2> xml을 import해서 가져온다.->이건 안되는듯? 버전 달라지면서 안되는듯함.
        // hello.

        //익명함수
        //1 -> 람다 방식
        textView.setOnClickListener {
            Log.d("click","Click!!")
        }
        //2 -> 익명 함수 방식
        textView.setOnClickListener(object:View.OnClickListener{
            override fun onClick(v: View?) {
                Log.d("click","Click!!")
            }
        })
        //3 -> 이름이 필요한 경우(click) -> 가장 풀어쓴 경우
        val click = object: View.OnClickListener{
            override fun onClick(v: View?) {
                textView.setText("안녕하세요")
                image.setImageResource(R.drawable.minoi)
                number+=10
                Log.d("number",number.toString())
            }
        }
        textView.setOnClickListener(click)



        // 뷰를 조작 하는 함수들
        // 1> setText
        // textView.setText("안녕하세요")
        // 2>setImageResource
        // image.setImageResource(R.drawable.minoi)

    }


}
