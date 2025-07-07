package com.ashu.freecodecampmasterclass.forLearning

fun main() {
    val list = listOf<Any>(1, "two", 3)
    val intArray = intArrayOf(2, 5, 7, 8)


    val genericFun = genericFunction<String>(age = list)
    println(genericFun)

}


/// reified: when converting to byte code we can se we dont know the type so
//  to solve the problem of type erasure we have reified keyword
inline fun <reified T> genericFunction(age: List<*>): Boolean {
    return age[1] is T
}

class MyClass {
    companion object MyObject {
        fun objFun() {

        }
    }
}