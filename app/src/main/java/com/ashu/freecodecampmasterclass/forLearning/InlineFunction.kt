package com.ashu.freecodecampmasterclass.forLearning


fun main() {
    calcTime {
        loop(10000000)
    }
}

 fun calcTime(fn: () -> Unit) {
    val start = System.currentTimeMillis()
    fn()
    val endTime = System.currentTimeMillis()
    println("DIFF-> ${endTime - start} ms")
}

fun loop(n: Long) {
    for (i in 1..n) {
        //...
    }
}