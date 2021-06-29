package com.example.myapplication.Kotlin

fun main(args:Array<String>){
    val a:Int? = null
    val b:Int = 10
    val c:Int = 100

    if(a==null) {
        println("a is null")
    }else{
        println("a is not null")
    }

    if (b+c==110){
        println("b plus c is 110")
    }else{
        println("b plus c is not 110")
    }

    // 엘비스 연산자
    // null대신 사용할 디폴트 값을 지정할 때 사용
    val number:Int? = 100
    val number2 = number ?:10//null이면 10, 아니면 number
    println()
    println(number2)
}