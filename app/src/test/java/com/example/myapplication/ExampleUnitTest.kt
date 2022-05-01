package com.example.myapplication

import com.github.javafaker.Faker
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    private val faker = Faker()

    @Test
    fun addition_isCorrect() {
        val user = User("Ivan", "Petrov", "Minsk")
        println(user)
        println("-----------------------------")

        for (i in 1..10){
            val user2 = User(faker.name().firstName(), faker.name().lastName(), faker.address().fullAddress())
            println(user2)
        }
    }
}