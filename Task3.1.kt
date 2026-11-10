/*Задание 3.1: Дан список чисел:
kotlin

val numbers = listOf(3, -1, 7, 0, -5, 10, 2)

Найди:

    Сумму всех чисел

    Количество положительных чисел

    Максимальное число*/

data class Person(val name: String, val age: Int)


fun main() {
    val numbers = listOf(3, -1, 7, 0, -5, 10, 2)

    println("Сумма: ${numbers.sum()}")
    println("Положительных: ${numbers.count { it > 0 }}")
    println("Максимум: ${numbers.maxOrNull()}")
}

