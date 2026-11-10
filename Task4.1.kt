/*Задание 4.1: Напиши greet(name: String = "гость", greeting: String = "Привет"): String, которая
возвращает "Привет, Алексей!". Проверь:

    greet() → "Привет, гость!"

    greet("Мария") → "Привет, Мария!"

    greet(greeting = "Здравствуйте", name = "Иван") → "Здравствуйте, Иван!".*/

 fun greet(name: String = "гость", greeting: String = "Привет") = "$greeting, $name!"

fun main() {
    println(greet())
    println(greet("Мария"))
    println(greet("Иван", "Здравствуйте"))
}