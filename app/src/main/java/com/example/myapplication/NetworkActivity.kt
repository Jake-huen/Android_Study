package com.example.myapplication

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Website.URL
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import org.w3c.dom.Text
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class NetworkActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_network)

        NetworkTask().execute()

    }
}

class NetworkTask(): AsyncTask<Any?, Any?, Array<PersonFromServer>>(){
    override fun onPostExecute(result: Array<PersonFromServer>?) {
        super.onPostExecute(result)
    }
    override fun doInBackground(vararg params: Any?): Array<PersonFromServer>? {
        val urlString:String = "http://mellowcode.org/json/students/"
        val url = URL(urlString)
        val connection:HttpURLConnection=url.openConnection() as HttpURLConnection

        connection.requestMethod="GET"
        connection.setRequestProperty("Content-Type","application/json")

        var buffer = ""
        if(connection.responseCode==HttpURLConnection.HTTP_OK){
            val reader = BufferedReader(
                InputStreamReader(
                    connection.inputStream,
                    "UTF-8"
                )
            )
            buffer = reader.readLine()
        }
        val data = Gson().fromJson(buffer,Array<PersonFromServer>::class.java)
        return data
    }
}

class PersonAdapter(
    val personList:Array<PersonFromServer>,
    val inflater:LayoutInflater
):RecyclerView.Adapter<>(){
    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val name:TextView
        val age:TextView
        val intro:TextView
    }
}