package com.example.myapplication.Kotlin

fun main(array:Array<String>){
    val tv = TV(listOf<String>("K","M","S"))
    tv.switch()
    println(tv.onOrOff)
    println(tv.checkCurrentChannel())
    tv.channelUp()
    println(tv.checkCurrentChannel())
    tv.channelUp()
    println(tv.checkCurrentChannel())
    tv.channelUp()
    println(tv.checkCurrentChannel())
    tv.channelUp()
    println(tv.checkCurrentChannel())
    tv.channelDown()
    println(tv.checkCurrentChannel())
    tv.channelDown()
    println(tv.checkCurrentChannel())
    tv.channelDown()
    println(tv.checkCurrentChannel())
    tv.channelDown()
    println(tv.checkCurrentChannel())

}
class TV(val channels:List<String>){
    var onOrOff:Boolean = false//True->On, False->Off
    var currentChannelNUmber = 0
        set(value){//누군가에 할당될때
            field = value
            //currentChannelNUmber=value
            if(field>2){
                field=0
            }
            if(field<0){
                field=2
            }
        }
        get(){//누군가에 의해 사용될때(불려나갈때)
            println("호출되었습니다.")
            return field//현재 currentNumber return
        }
    fun switch(){
        onOrOff=!onOrOff
    }
    fun checkCurrentChannel():String{
        return channels[currentChannelNUmber]
    }
    fun channelUp(){
        currentChannelNUmber+=1
        //channels.forEachIndexed{index,value->
        //    if(currentChannelNUmber==index){
        //        currentChannelNUmber=currentChannelNUmber+1
        //        return
        //    }
        //}
    }
    fun channelDown(){
        currentChannelNUmber-=1
    }
}