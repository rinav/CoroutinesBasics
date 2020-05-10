package dev.rinav.basics

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {

    // coroutines are very lightweight as you can see we are launching 10 lacks coroutines
    runBlocking {
        repeat(1_000_000) {
            launch {
                print(".")
            }
        }
    }
}