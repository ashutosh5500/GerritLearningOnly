package com.ashu.freecodecampmasterclass.forLearning

import androidx.lifecycle.LiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

data class Notes(var title: String)

fun main() {

    runBlocking {
        launch {
            try {
                val data: Flow<Int> = producer()

                /// flowOn ke upr IO wale pr execute hoge and niche wale main pr

                data.map {
                    delay(1000)
                    println("Map-> $it-----${Thread.currentThread().name}")
                    it * 2
                }.flowOn(Dispatchers.Default).filter {
                    delay(500)
                    println("Filter-> $it-----${Thread.currentThread().name}")
                    it < 8

                }.flowOn(Dispatchers.IO).collect {
                    println("DATA-> $it-----${Thread.currentThread().name}")
                }

            } catch (e: Exception) {
                println("EX-> ${e.message}")
            } finally {
                println("CLEAN")
            }
        }

    }
}

fun producer(): Flow<Int> {
    return flow {
        val list = listOf<Int>(1, 2, 3, 4, 5)

        list.forEach {
            delay(1000)
            println("PRODUCER-> ${Thread.currentThread().name}")
            emit(it)
            throw Exception("ERROR in emitter lalala")
        }
    }.catch {
        println("error in producer $it")
        emit(-1)
    }
}
