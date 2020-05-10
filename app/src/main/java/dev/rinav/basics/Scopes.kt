package dev.rinav.basics

import kotlinx.coroutines.*

fun main() {

    println("Program execution will now block")

    runBlocking {
        launch {
            delay(1000)
            println("Task from runBlocking")
        }

        GlobalScope.launch {
            delay(500)
            println("Task from GlobalScope")
        }

        coroutineScope { // Creates a coroutine scope
            println("Create a coroutine scope")

            launch {
                delay(300)
                println("Task from nested coroutine scope launch")
            }

            delay(200)
            // This line will be printed before the nested launch
            println("Task from coroutine scope")
        }
    }

    println("Program execution will now continue")
}