package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_recycler_view.*

class RecyclerViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        val carList = ArrayList<CarForList>()
        for(i in 0 until 100){
            carList.add(CarForList(""+i+"번째 자동차",""+i+"순위 엔진"))
        }
        val adapter = RecyclerViewAdapter(carList, LayoutInflater.from(this@RecyclerViewActivity))
        recycler_view.adapter=adapter
        recycler_view.layoutManager=LinearLayoutManager(this@RecyclerViewActivity)
        // recycler_view.layoutManager=GridLayoutManager(this@RecyclerViewActivity,2)
    }
}

class RecyclerViewAdapter(
    val itemList:ArrayList<CarForList>,
    val inflater:LayoutInflater
):RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>(){

    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val carName:TextView
        val carEngine:TextView

        init{
            carName=itemView.findViewById(R.id.car_name)
            carEngine=itemView.findViewById(R.id.car_engine)
            itemView.setOnClickListener {
                val position:Int = adapterPosition
                val engineName = itemList.get(position).engine
                Log.d("engine",engineName)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.item_view,parent,false)
        return ViewHolder(view)
    }//ViewHolder생성되는 함수

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.carName.setText(itemList.get(position).name)
        holder.carEngine.setText(itemList.get(position).engine)
    }//생성된 뷰홀더에 데이터를 바인딩 해주는 함수

    override fun getItemCount(): Int {
        return itemList.size
    }
}

//흐름
//1. onCreateViewHolder에서 view를 만든것을 viewholder에 넣어준다(아이템 하나씩)
//2. viewholder에서 init으로 carname, carengine만 설정
//3. onBindViewHolder에서 setText로 내용 설정

// ViewHolder : 뷰객체를 기억하고 있을 객체
// Adapter : 모든 아이템이 담긴 리스트를 RecyclerView에 Binding 시켜주기 위한 사전 작업이 이루어 지는 객체
// LayoutManager: 스크롤 위아래로 할지, 좌우로 할지 이런거 결정