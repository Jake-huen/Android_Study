package com.example.myapplication.Kotlin

fun main(array:Array<String>){
    first()
    println(second(80))
    println(third(89))
    gugudan()
}

fun first(){
    var a= mutableListOf<Int>(0,1,2,3,4,5,6,7,8,9)
    //var list1 = MutableList(9,{0})
    var b= mutableListOf<Boolean>()
    //var list2 = MutableList(9,{true})
    for(item in a){
        if(item%2==0) {
            b.add(true)
        }else{
            b.add(false)
        }
    }
    println(a)
    println(b)
}
fun second(score:Int):String{
    if(score in 80..90){
        return "A"
    }else if(score in 70..79){
        return "B"
    }else if(score in 60..69){
        return "C"
    }else{
        return "F"
    }
}
fun third(number:Int):Int{
    if(number>10){
        return number/10+number%10
    }else{
        return number
    }
}
fun gugudan(){
    for(i in 1..9){
        for(j in 1..9){
            println("$i"+"X"+j+"="+i*j)
        }
    }
}