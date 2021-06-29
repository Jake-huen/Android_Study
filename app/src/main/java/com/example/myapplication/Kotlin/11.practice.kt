package com.example.myapplication.Kotlin

// 11. 제어흐름 실습

fun main(args: Array<String>) {
    val value: Int? = null
    when (value) {
        null -> println("value is null")
        else -> println("value is not null")
    }
    val value2: Boolean? = null

    //when 구문은 조건으로 갖는 값의 모든 경우에 대응 해주는 것이 좋다.
    when (value2) {
        true -> {
            println("true")
        }
        false -> {
            println("false")
        }
        null -> {
            println("null")
        }
    }
    //값을 리턴하는 when 구문의 경우 반드시 값을 리턴해야 된다.
    val value3 = when (value2) {
        true -> 1
        false -> 3
        else -> 4
    }
    val value4: Int = 10
    when (value4) {
        is Int -> {
            println("value4 is Int")
        }
        else -> {
            println("value4 is not Int")
        }
    }
    //when 의 다양한 조건식
    val value5: Int = 87
    when (value5) {
        in 60..70 -> {
            println("value is in 60 ~ 70")
        }
        in 70..80 -> {
            println("value is in 70 ~ 80")
        }
    }
}