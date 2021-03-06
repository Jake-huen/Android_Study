package com.example.myapplication.android_study

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.google.gson.Gson
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class NetworkActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_network)
        val recycler_person:RecyclerView = findViewById(R.id.recycler_person)
        NetworkTask(
            recycler_person,
            LayoutInflater.from(this@NetworkActivity)
        ).execute()

    }
}

class NetworkTask(
    val recyclerView: RecyclerView,
    val inflater: LayoutInflater
): AsyncTask<Any?, Any?, Array<PersonFromServer>>(){
    // AsyncTask에서 doInBackground 작업 마무리 한 다음에 MainThread로 돌아갈 수 있는 부분
    override fun onPostExecute(result: Array<PersonFromServer>?) {//MainThread에서 실행됨
        // 여기는 UI 쓰레드에 접근 가능하기 때문에 여기에 뷰를 그려준다.
        val adapter = PersonAdapter(result!!,inflater)
        recyclerView.adapter = adapter
        super.onPostExecute(result)
    }
    override fun doInBackground(vararg params: Any?): Array<PersonFromServer>? {
        val urlString:String = "http://mellowcode.org/json/students/"
        val url:URL= URL(urlString)
        val connection:HttpURLConnection=url.openConnection() as HttpURLConnection

        connection.requestMethod="GET"
        connection.setRequestProperty("Content-Type","application/json")//보내는 속성,content type

        var buffer = ""
        if(connection.responseCode==HttpURLConnection.HTTP_OK){
            val reader = BufferedReader(//BufferedReader -> 뭉태기로 읽겠다
                InputStreamReader( //InputStream을 읽을수 있는애
                    connection.inputStream,
                    "UTF-8" //UTF-8형식으로 inputStream을 읽겠다
                )
            )
            buffer = reader.readLine()
        }
        val data = Gson().fromJson(buffer,Array<PersonFromServer>::class.java)
        // val age = data[0].age
        return data
    }
}

class PersonAdapter(
    val personList: Array<PersonFromServer>?,
    val inflater:LayoutInflater
):RecyclerView.Adapter<PersonAdapter.ViewHolder>(){
    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val name:TextView
        val age:TextView
        val intro:TextView
        init{
            name = itemView.findViewById(R.id.person_name)
            age = itemView.findViewById(R.id.person_age)
            intro = itemView.findViewById(R.id.person_ment)
        }
    }

    override fun getItemCount(): Int {
        return personList!!.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.personlistitem,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.setText(personList!!.get(position).name ?:"")
        holder.age.setText(personList.get(position).age.toString())
        holder.intro.setText(personList.get(position).intro ?:"")

    }
}


// 포스트맨
// android.os.NetworkOnMainThreadException -> mainThread는 절대 정지시킬 수 없다
// 네트워크는 반드시 비동기로 해야된다. => MainThread에서 진행하면 안됨!
// 비동기 처리 방식은 AsyncTask가 있다.

// json ->