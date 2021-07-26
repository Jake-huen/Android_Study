package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import io.realm.Realm
import io.realm.RealmConfiguration

class RealmActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_realm)

        Realm.init(this@RealmActivity)
        val config : RealmConfiguration=RealmConfiguration.Builder()
            .deleteRealmIfMigrationNeeded()
            .build()
        Realm.setDefaultConfiguration(config)
        val realm = Realm.getDefaultInstance()

        val button_save:Button=findViewById(R.id.button_save)
        val button_load:Button=findViewById(R.id.button_load)
        val button_delete:Button=findViewById(R.id.button_delete)
        button_save.setOnClickListener {
            realm.executeTransaction {
                // A테이블에서 데이터를 가져온다
                // B테이블에서 데이터를 가져온다
                // C테이블에서 데이터를 가져온다
                // 조합을 한다
                // D테이블에서 저장을 한다
                // 이러한 작업 단위를 묶어버린다!!(데이터가 바뀔수있으므로)
                // begin,commit을 묶었다고 생각
                with(it.createObject(School::class.java)){
                    this.name="건국 대학교"
                    this.location="서울 광진구"
                }
            }
        }
        button_load.setOnClickListener {
            realm.executeTransaction {
                val data = it.where(School::class.java).findFirst()
                Log.d("dataa","data:"+data)
            }
        }
        button_delete.setOnClickListener {
            realm.executeTransaction {
                it.where(School::class.java).findAll().deleteAllFromRealm()
            }
        }
    }
}