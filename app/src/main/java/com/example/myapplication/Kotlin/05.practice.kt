package com.example.myapplication.Kotlin

fun plusThree(first: Int, second: Int, third: Int): Int {
    val result = first + second + third
    return result
}

fun minusThree(first:Int,second:Int,third:Int)=first-second-third

fun multiplyThree(first:Int=1,second:Int=1,third:Int=1):Int{
    return first*second*third
}
//내부 함수
//함수 안에 함수가 있다
fun showMyPlus(first:Int,second:Int):Int{
    fun plus(first:Int,second:Int):Int{
        return first+second
    }
    return plus(first,second)
}
fun main(array:Array<String>){
    val result = plusThree(1,2,3)
    println(result)
    val result2 = minusThree(10,1,2)

}

