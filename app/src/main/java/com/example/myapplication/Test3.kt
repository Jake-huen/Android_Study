package com.example.myapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import org.w3c.dom.Text

class Test3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test3)

        val phonemembers=ArrayList<phone_member>()
        for(i in 0 until 10){
            phonemembers.add(phone_member(""+i+"번째 친구",""+i+"순위 친구"))
        }
        val container = findViewById<LinearLayout>(R.id.test3_addview)
        val inflater = LayoutInflater.from(this@Test3)
        for(i in 0 until phonemembers.size){
            val test3_item_view=inflater.inflate(R.layout.test3_item_view,null)
            val main_name = test3_item_view.findViewById<TextView>(R.id.main_name)
            val people_name = test3_item_view.findViewById<TextView>(R.id.people_name)
            val minoi_button = test3_item_view.findViewById<ImageButton>(R.id.minoi_button)

            main_name.setText(phonemembers.get(i).name)
            people_name.setText(phonemembers.get(i).story)
            minoi_button.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://youtube.com"))
            }
            container.addView(test3_item_view)
        }
    }
}

class phone_member(val name:String,val story:String){

}