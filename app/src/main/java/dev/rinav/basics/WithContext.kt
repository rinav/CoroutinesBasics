package dev.rinav.basics

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

fun main() {

    runBlocking {

        launch(Dispatchers.Default) {

            println("First Context: $coroutineContext")

            withContext(Dispatchers.IO) {
                println("Second Context: $coroutineContext")
            }

            println("Third Context: $coroutineContext")

            withContext(Dispatchers.Default) {
                println("Fourth Context: $coroutineContext")
            }

            println("Fifth Context: $coroutineContext")
        }
    }
}