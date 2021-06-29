package com.example.myapplication.Kotlin

// 과제
// Night,Monster(부모) -> Character
// SuperNight, SuperMOnster(자식)

fun main(array:Array<String>){
    val monster = SuperMonster(100,10)
    val night = SuperNight(130,8)
    monster.bite(night)
}

//상속이 만들어낸 특징
//- 자식 클래스는 부모 클래스의 타입이다.

open class Character(var hp:Int, val power:Int){
    fun attack(character:Character,power:Int=this.power){
        character.defense(power)
    }
    open fun defense(damage:Int){
        hp-=damage
        if(hp>0) println("${javaClass.simpleName}의 남은 체력은 $hp 입니다.")
        else println("아군이 당했습니다.")
    }
}
//자식 클래스가 인스턴스화 되기 위해서 부모 클래스 선행되서 인스턴스화 되어야 한다
class SuperNight(hp:Int,power:Int):Character(hp,power){
    val defensePower = 2
    override fun defense(damage: Int) {
        super.defense(damage-defensePower)
    }
}
class SuperMonster(hp:Int,power:Int):Character(hp,power){
    override fun defense(damage: Int) {
        super.defense(damage)
    }
    fun bite(character:Character){
        super.attack(character,power+2)
    }
}