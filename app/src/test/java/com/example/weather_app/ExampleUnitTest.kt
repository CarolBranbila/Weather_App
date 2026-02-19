package com.example.weather_app

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        val item = mutableListOf<Int>()
        repeat(1000) {
            item.add(it)
        }
        val array2 = arrayOf<Int>()

        array2[2] = 3

        mutableListOf<Int>()
        //array
        assertEquals(4, 2 + 2)
    }
}