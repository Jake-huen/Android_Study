package com.example.myapplication.Kotlin

//12.배열

//배열이 필요한 이유
//-그룹이 필요할때
fun main(array: Array<String>) {

//    val one:Int = 1
//    val two:Int = 2
//    val three:Int = 3
//    val four:Int = 4
//    val five:Int = 5
    var group1 = arrayOf<Int>(1, 2, 3, 4, 5)

    println(group1 is Array)

    //배열을 생성하는 방법(2)
    var number1 = 10 // 변수의 자료형 적지 않아도 10을 보고 자동으로 Int가 됨
    var group2 = arrayOf(1,2,3.5,4,"Hello")
    //그러나 arrayOf타입을 적어주지 않으면
    //아무거나 넣을 수 있다.

    //Index 란
    //->순서(번째)
    //0부터 시작

    //배열의 값을 꺼내는 방법(1)
    val test1 = group1.get(0)
    val test2 = group1.get(4)
    println(test1)
    println(test2)

    //배열의 값을 바꾸는 방법(1)
    group1.set(0,100)//0번째를 100으로 바꾸겠다
    println(group1[0])

    //배열의 값을 바꾸는 방법(2)
    group1[0]=200
    println(group1[0])
}