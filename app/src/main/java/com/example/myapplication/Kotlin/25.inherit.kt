package com.example.myapplication.Kotlin

// 두번까지는 봐준다
// 두번 이상이 넘어가면 리펙토링 해라

// 25. 상속
// 부모로부터 설명서를 물려받는다.
fun main(args:Array<String>){
    val superCar100:SuperCar100= SuperCar100()
    println(superCar100.drive())
    superCar100.stop()

    val bus100:Bus100 = Bus100()
    println(bus100.drive())
}
//부모:Car100
//자식:SuperCar100,Bus100,Truck100
open class Car100(){
    open fun drive():String{
        return "달린다"
    }
    fun stop(){

    }
}
//class는 private이 달려있기 때문에 외부에서 접근할 수 없다.
//상속도 외부에서의 접근이다.
//open이라는 키워드를 사용하자
class SuperCar100():Car100(){
    override fun drive():String {
        val run = super.drive()
        return "빨리 $run"
    }
}

class Truck100():Car100(){

}

class Bus100():Car100(){

}