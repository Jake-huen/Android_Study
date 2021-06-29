package com.example.myapplication.Kotlin
//1)사칙 연산 수행
//2)은행 계좌 만들기
//  - 계좌 생성 기능(이름, 생년 월일, 초기금액)
//  - 잔고를 확인 하는 기능
//  - 출금 기능
//  - 예금 기능
//3)TV 클래스
//  - on/off 기능
//  - 채널을 돌리는 기능
//  - 초기 채널은 (S사 M사 K사 3개)
fun main(array:Array<String>){
    val calculator1=calculator1()
    //println(calculator1.plus(4,5))
    //println()
    val calculator2=calculator2()
    //println(calculator2.plus(23,5234,234,2234,234))
    val calculator3=calculator3(3)
    calculator3.plus(5).minus(5)
    //Chaining(체이닝)


}
class calculator1(){
    fun plus(a:Int,b:Int):Int{
        return a+b
    }
    fun minus(a:Int,b:Int):Int{
        if(a>b) return a-b
        else return b-a
    }
    fun multiple(a:Int,b:Int):Int{
        return a*b
    }
    fun divide(a:Int,b:Int):Int{
        return a/b
    }
}
class calculator2(){
    fun plus(vararg numbers:Int):Int{
        var result:Int=0
        numbers.forEach{
            result=result+it
        }
        return result
    }
    fun minus(vararg numbers:Int):Int{
        var result:Int=numbers[0]
        for(i in 1 until numbers.size){
            result=result-numbers[i]
        }
        return result
    }
    fun multiply(vararg numbers:Int):Int{
        var result:Int=1
        numbers.forEach{
            if(it!=0){
                result*=it
            }
        }
        return result
    }
    fun divide(vararg numbers:Int):Int{
        var result:Int = numbers[0]
        numbers.forEachIndexed{index,value->
            if(index!=0 && value != 0) {
                result = result / value
            }
        }
        return result
    }
}
class calculator3(val initialValue:Int){
    fun plus(number:Int):calculator3{
        val result=this.initialValue+number
        return calculator3(result)
    }
    fun minus(number:Int):calculator3{
        val result=this.initialValue-number
        return calculator3(result)
    }
    fun multiply(number:Int):calculator3{
        val result = this.initialValue*number
        return calculator3(result)
    }
    fun divide(number:Int):calculator3{
        val result=this.initialValue/number
        return calculator3(result)
    }
}
