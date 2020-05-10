package dev.rinav.basics

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

var functionCalls = 0

fun main() {

    GlobalScope.launch { completeMessage() }
    GlobalScope.launch { improveMessage() }

    print("Hello, ")
    Thread.sleep(2000)
    println("There have been $functionCalls calls so far")
}

suspend fun completeMessage() {
    delay(500)
    println("World!")
    functionCalls++
}

suspend fun improveMessage()  {
    delay(1000)
    println("Suspend functions are cool")
    functionCalls++
}
