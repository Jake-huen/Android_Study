package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit)

        val retrofit = Retrofit.Builder()
            .baseUrl("http://mellowcoce.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(RetrofitService::class.java)
        //GET 요청
        service.getStudentsList().enqueue(object: Callback<ArrayList<PersonFromServer>>{
            //enque : 대기줄에 올려놨다는 의미
            override fun onResponse(
                call: Call<ArrayList<PersonFromServer>>,
                response: Response<ArrayList<PersonFromServer>>
            ) {
                if(response.isSuccessful){
                    val personList=response.body()
                    Log.d("retrofitt","res:"+personList?.get(0)?.age)

                    // val code=response.code()
                    // val error = response.errorBody()
                    // val header = response.headers()
                }
            }

            override fun onFailure(call: Call<ArrayList<PersonFromServer>>, t: Throwable) {
                // 통신 실패했을때
                Log.d("retrofitt","ERROR")
                call.isCanceled
                call.isExecuted
                call.cancel()
            }

        })
        // POST 요청 (1)
//        val params = HashMap<String,Any>()
//        params.put("name","김태헌")
//        params.put("age",20)
//        params.put("intro","안녕하세요")
//        service.createStudent(params).enqueue(object:Callback<PersonFromServer>{
//            override fun onResponse(
//                call: Call<PersonFromServer>,
//                response: Response<PersonFromServer>
//            ) {
//                if(response.isSuccessful){
//                    val person = response.body()
//                }
//            }
//            override fun onFailure(call: Call<PersonFromServer>, t: Throwable) {
//            }
//        })
        // POST 요청 (2)
        val person = PersonFromServer(name="아이유",age=12,intro="이이ㅣㅣㅣ")
        service.createStudentEasy(person).enqueue(object:Callback<PersonFromServer>{
            override fun onResponse(
                call: Call<PersonFromServer>,
                response: Response<PersonFromServer>
            ) {
                if(response.isSuccessful){
                    val person = response.body()
                }
            }
            override fun onFailure(call: Call<PersonFromServer>, t: Throwable) {
            }
        })
    }
}