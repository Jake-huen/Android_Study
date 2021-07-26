package com.example.myapplication.Kotlin

var a = 1+2+3+4+5
var b = "1"
var c = b.toInt()//b를 int로 바꾼값이 저장됨
var d = b.toFloat()//d에는 1.0이 있음

var e = "John"
var f = "My name is $e Nice to meet you"

//Null
//-존재하지 않는다

//var abc : Int = null
var abc1 : Int? = null//자료형 뒤에 ?를 붙이면 null을 가질 수 있는 자료형이 된다.

var g = a+3
fun main(array:Array<String>){
    println(a)
    println(b)
    println(c)
    println(d)
    println(e)
    println(f)
    println(abc1)

    println(g)
}