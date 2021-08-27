package com.example.myapplication

import android.app.Application
import com.example.myapplication.android_study.RetrofitService
import com.facebook.stetho.okhttp3.StethoInterceptor
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MasterApplication:Application() {

    lateinit var service:RetrofitService
    override fun onCreate() {
        super.onCreate()

    }

    fun createRetrofit(){
        // retrofit만들때 header도 장착을 해주어야함
        // 스테토 library 사용
        val header = Interceptor{//통신 가로채기
            val original = it.request()//원래 나갈려던거 잡아두기
            val request = original.newBuilder()//original 개조
                .header("Authorization","")
                .build()
            it.proceed(request)//개조한것을 넣어서 내보냄
        }
        val client = OkHttpClient.Builder()
            .addInterceptor(header)
            .addNetworkInterceptor(StethoInterceptor())//network를 stethoInterceptor가 낚아채는거
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("http://mellowcode.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
        service = retrofit.create(RetrofitService::class.java)
    }

    fun checkIsLogin():Boolean{
        
    }

}
//ctivity 보다 application이 우선함