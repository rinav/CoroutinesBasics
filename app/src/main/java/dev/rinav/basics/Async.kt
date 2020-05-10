package dev.rinav.basics

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.random.Random

fun main() {

    runBlocking {

        val firstDeferred = async { getFirstValue() }
        val secondDeferred = async { getSecondValue() }

        println("Doing some processing here")
        delay(1000)
        println("Waiting for values")

        val firstValue = firstDeferred.await()
        val secondValue = secondDeferred.await()

        println("The total is ${firstValue + secondValue}")
    }
}

suspend fun getFirstValue(): Int {
    delay(2000)

    return  Random.nextInt(100).also {
        println("Returning first value $it")
    }
}

suspend fun getSecondValue(): Int {
    delay(4000)

    return Random.nextInt(200).also {
        println("Returning second value $it")
    }
}