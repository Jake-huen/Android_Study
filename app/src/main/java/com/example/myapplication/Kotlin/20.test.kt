package com.example.myapplication.Kotlin
fun main(array:Array<String>){
    val account: bankAccount=bankAccount("김태헌","19980315",1000)
    println(account.checkleft())
    println(account.distract(2000))
    println(account.put(3000))
    println()
    val account2 = Account("김태헌","19980315",-2000)
    println(account2.checkleft())
    println()
    val account3=Account2("김태헌","19980315",3000)
    println(account3.checkleft())
}
class bankAccount(val name:String,val birth:String,var balance:Int){
    fun checkleft():Int{
        return balance
    }
    fun distract(temp:Int):Boolean{
        if(balance> temp) {
            balance-=temp
            return true
        }else{
            return false
        }
    }
    fun put(temp:Int){
        balance+=temp
    }
}
class Account{
    val name:String
    val birth:String
    var balance:Int
    constructor(name:String,birth:String,balance:Int){
        this.name=name
        this.birth=birth
        if(balance>=0){
            this.balance=balance
        } else{
            this.balance=0
        }
    }
    fun checkleft():Int{
        return balance
    }
    fun distract(temp:Int):Boolean{
        if(balance> temp) {
            balance-=temp
            return true
        }else{
            return false
        }
    }
    fun put(temp:Int){
        balance+=temp
    }
}
class Account2(val name:String,val birth:String,var balance:Int=1000){
    fun checkleft():Int{
        return balance
    }
    fun distract(temp:Int):Boolean{
        if(balance> temp) {
            balance-=temp
            return true
        }else{
            return false
        }
    }
    fun put(temp:Int){
        balance+=temp
    }
}
class Account3(initialBalance:Int){

    val balance:Int = if(initialBalance>=0) initialBalance else 0
    fun checkBalance():Int{
        return balance
    }
}