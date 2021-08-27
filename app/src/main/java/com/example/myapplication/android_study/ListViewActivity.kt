package com.example.myapplication.android_study

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import android.widget.Toast
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_list_view.*

class ListViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        // 아이템 리스트 준비
        val carList = ArrayList<CarForList>()
        for(i in 0 until 100){
            carList.add(CarForList(""+i+"번째 자동차",""+i+"순위 엔진"))
        }
        val adapter= ListViewAdapter(carList, LayoutInflater.from(this@ListViewActivity))
        listView.adapter=adapter
        listView.setOnItemClickListener { parent, view, position, id ->
            var carName = (adapter.getItem(position) as CarForList).name
            var carEngine = (adapter.getItem(position) as CarForList).engine

            Toast.makeText(this@ListViewActivity,carName+" "+carEngine,Toast.LENGTH_LONG).show()
        }
    }
}

class ListViewAdapter(
    val carForList: ArrayList<CarForList>,
    val layoutInflater: LayoutInflater
) : BaseAdapter(){

    override fun getCount(): Int {
        // 그리고자 하는 아이템 리스트의 전체 갯수
        return carForList.size
    }

    override fun getItem(position: Int): Any {
        // 그리고자 하는 아이템 리스트의 하나(포지션에 해당하는)
        return carForList.get(position)
    }

    override fun getItemId(position: Int): Long {
        // 해당 포지션에 위치해 있는 아이템뷰의 아이디 설정
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
//        val view = layoutInflater.inflate(R.layout.item_view,null)
//        var carNameTextView = view.findViewById<TextView>(R.id.car_name)
//        var carEngineTextView = view.findViewById<TextView>(R.id.car_engine)
//        carNameTextView.setText(carForList.get(position).name)
//        carEngineTextView.setText(carForList.get(position).engine)
//        return view
        val view:View
        val holder: ViewHolder
        if(convertView==null){//재사용할게 없다
            Log.d("convert","1")
            view=layoutInflater.inflate(R.layout.item_view,null)
            holder= ViewHolder()

            holder.carName=view.findViewById(R.id.car_name)
            holder.carEngine=view.findViewById(R.id.car_engine)
            view.tag = holder
        }else{
            Log.d("convert","2")
            holder = convertView.tag as ViewHolder
            view = convertView
        }
        holder.carName?.setText(carForList.get(position).name)
        holder.carEngine?.setText(carForList.get(position).engine)

        return view
    }
}

// view에서 carNameTextView와 carEngineTextView를 findViewById로 받아오는것을 개선하기 위한 작업
class ViewHolder{
    var carName:TextView?=null
    var carEngine:TextView?=null
}