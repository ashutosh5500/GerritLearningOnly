package com.ashu.freecodecampmasterclass.forLearning

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

fun main() {
    NotificationFactory.createNoti("email").notifyUser()
    val user = UserBuilder().run {
        name = "ashu"
        age = 19
    }

    println("USER-> ${user}")

}

/// 1. SINGLETON
object AnyName {
    fun doSomething() {
        println("DO something")
    }
}

/// 2. FACTORY PATTERN

interface Notification {
    fun notifyUser()
}

class EmailNotification : Notification {
    override fun notifyUser() {
        println("email noti")
    }
}

class SMSNotification : Notification {
    override fun notifyUser() {
        println("SMS noti")
    }
}

object NotificationFactory {
    fun createNoti(type: String): Notification {
        return when (type) {
            "email" -> EmailNotification()
            "sms" -> SMSNotification()
            else -> throw IllegalArgumentException("UNKNOWN")
        }
    }
}

/// 3. builder pattern -> contruct complex onbjects step by step

data class User(val name: String, val age: Int)

class UserBuilder {
    var name: String = ""
    var age: Int = 0

    fun builder(): User {
        return User(name, age)
    }
}

/// 4. observer pattern

class UserViewModel : ViewModel() {


    private val _user = MutableLiveData<String>()
    val user: LiveData<String> = _user

    fun setUser(v: String) {
        _user.value = v
    }

}

/// 5. strategy pattern change behaviour at runtime by using interchangeable

