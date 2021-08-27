package com.example.myapplication.android_study

import io.realm.RealmObject

open class School :RealmObject(){
    var name : String? = null
    var location:String? = null
}