package com.example.myapplication.android_study

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_phone_book_recycler_view.*

class PhoneBookRecyclerView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_book_recycler_view)

//        phonebook_recycler_view.adapter = phoneBookRecyclerAdapter
//        phonebook_recycler_view.layoutManager=LinearLayoutManager(this@PhoneBookRecyclerView)
        with(phonebook_recycler_view){
            this.adapter= PhoneBookRecyclerAdapter(
                phoneBookList=createFakePhoneBook(30),
                inflater=LayoutInflater.from(this@PhoneBookRecyclerView),
                activity=this@PhoneBookRecyclerView)
            this.layoutManager=LinearLayoutManager(this@PhoneBookRecyclerView)
        }
    }
    fun createFakePhoneBook(fakeNumber:Int=10,phoneBook: PhoneBook = PhoneBook()): PhoneBook {
        for(i in 0 until fakeNumber){
            phoneBook.addPerson(Person(name = ""+(i+1)+"번째 사람", number=""+i+"번째 사람의 전화 번호"))
        }
        return phoneBook
    }
}

class PhoneBookRecyclerAdapter(
    val phoneBookList: PhoneBook,
    val inflater:LayoutInflater,
    val activity: Activity
): RecyclerView.Adapter<PhoneBookRecyclerAdapter.ViewHolder>(){
    inner class ViewHolder(itemView:View) :RecyclerView.ViewHolder(itemView){
        val personName :TextView
        init{
            personName=itemView.findViewById(R.id.person_name)
            itemView.setOnClickListener {
                val intent = Intent(activity, PhoneBookDetailActivity::class.java)
                intent.putExtra("name",phoneBookList.personList.get(absoluteAdapterPosition).name)
                intent.putExtra("number",phoneBookList.personList.get(absoluteAdapterPosition).number)
                activity.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.phonebookitem,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.personName.setText(phoneBookList.personList.get(position).name)
    }

    override fun getItemCount(): Int {
        return phoneBookList.personList.size
    }
}