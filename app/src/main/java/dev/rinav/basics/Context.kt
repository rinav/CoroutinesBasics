package dev.rinav.basics

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {

    runBlocking {
        launch(CoroutineName("myCoroutine")) {
            println("This is run from ${coroutineContext[CoroutineName.Key]}")
            println("This is run from $coroutineContext")
        }
    }
}