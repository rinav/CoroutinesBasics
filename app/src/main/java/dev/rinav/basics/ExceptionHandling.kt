package dev.rinav.basics

import kotlinx.coroutines.*

fun main() {

    runBlocking {

        val exceptionHandler = CoroutineExceptionHandler { handler, throwable ->
            println("Handled Exception in exceptionalHandler :: ${throwable.localizedMessage}")
        }

        val job = GlobalScope.launch(exceptionHandler) {

            println("Throwing exception from job")
            throw IndexOutOfBoundsException("Exception in coroutine")
        }

        job.join()

        val deferred = GlobalScope.async {
            println("Throwing exception from async")
            throw ArithmeticException("Exception in async")
        }

        try {
            deferred.await()
        } catch (e: ArithmeticException) {
            println("Handled Exception in trycatch :: ${e.localizedMessage}")
        }
    }
}