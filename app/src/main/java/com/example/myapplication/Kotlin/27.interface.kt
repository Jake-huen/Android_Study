package com.example.myapplication.Kotlin
// 27.인터페이스
// - 인터페이스는 약속 ! -> 니가 이것을 구현하면 너도 이 타입이다!
// - 생성자가 없다 -> 인스턴스화 시킬 수 없다 -> 설명서가 아니다
// - 지침서 -> 니가 이것을 구현하고 싶다면 반드시 아래 기능을 구현해라!

fun main(args:Array<String>){
    val student_:Student_ = Student_()
    student_.eat()
    student_.sleep()
}
interface Person_{
    fun eat()
    fun sleep()
}

class Student_ : Person_{
    override fun eat() {

    }

    override fun sleep() {

    }
}
class SoccerPlay : Person_{
    override fun eat() {

    }

    override fun sleep() {

    }

}

















open class Person(){
    open fun eat(){

    }
    fun sleep(){

    }
}

class Student() : Person(){
    override fun eat(){
        super.eat()
    }
}

class Teacher() : Person(){
    override fun eat(){
        super.eat()
    }
}