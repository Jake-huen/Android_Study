package com.example.myapplication.android_study

import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_async_.*
import java.lang.Exception

class Async_Activity : AppCompatActivity() {
    var task : BackgroundAsyncTask? = null
    var task1 : BackgroundAsyncTask? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_async_)
        val start:Button=findViewById(R.id.start)
        val stop:Button=findViewById(R.id.stop)
        // val ment:TextView=findViewById(R.id.ment)

        start.setOnClickListener {
            task= BackgroundAsyncTask(progressbar,ment)
            task1= BackgroundAsyncTask(progressbar,ment)
            task?.execute()
            task1?.execute()
        }

        stop.setOnClickListener {
            // task?.cancel(true)
            startActivity(Intent(this, Intent2::class.java))
        }
    }

    override fun onPause() {
        task?.cancel(true)
        super.onPause()
    }
}

class BackgroundAsyncTask(
    val progressbar : ProgressBar,
    val progressText : TextView
):AsyncTask<Int,Int,Int>(){
    // params => doInBackground 에서 사용할 타입
    // progress => onProgressUpdate 에서 사용할 타입
    // result => onPostExecute 에서 사용할 타입
    var percent:Int = 0

    override fun onPreExecute() {
        percent = 0
        progressbar.setProgress(percent)
    }

    override fun doInBackground(vararg params: Int?): Int {
        while (isCancelled()==false){
            percent++
            if(percent>100){
                break
            }else{
                publishProgress(percent)
            }
            try{
                Thread.sleep(100)
            }catch (e:Exception){
                e.printStackTrace()
            }
        }
        return percent
    }

    override fun onProgressUpdate(vararg values: Int?) {
        progressbar.setProgress(values[0] ?:0)
        progressText.setText("퍼센트 : "+values[0])
        super.onProgressUpdate(*values)
    }

    override fun onPostExecute(result: Int?) {
        progressText.setText("작업이 완료되었습니다.")
    }

    override fun onCancelled() {
        progressbar.setProgress(0)
        progressText.setText("작업이 취소되었습니다.")
    }

}