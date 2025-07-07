package com.ashu.freecodecampmasterclass.forLearning


sealed class Result1<out T> {
    data class Success<T>(val data: T) : Result1<T>()
    data class Failure(val error: Exception) : Result1<Nothing>()
    data object Loading : Result1<Nothing>()

    fun handle(result: Result1<Order>) {
        when (result) {
            is Success -> println("SUCCESS")
            is Failure -> println("SUCCESS")
            is Loading -> println("SUCCESS")
        }
    }
}

data class Order(val id: Int)