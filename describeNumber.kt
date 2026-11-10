/*Задание 1.1 (10 мин). Напиши функцию describeNumber(n: Int): String, которая возвращает:

"Отрицательное", если n < 0

"Ноль", если n == 0

"Положительное", если n > 0

90..100 → "A"

80..89 → "B"

70..79 → "C"

60..69 → "D"

0..59 → "F"

иначе → "Некорректный балл"

*/

fun describeNumber(n: Int) = when {
    n < 0 -> "Отрицательное"
    n == 0 -> "Ноль"
    else -> "Положительное"
}

fun gradeForScore(score: Int) = when (score) {
    in 90..100 -> "A"
    in 80..89 -> "B"
    in 70..79 -> "C"
    in 60..69 -> "D"
    in 0..59 -> "F"
    else -> "Некорректный балл"
}

fun rateMovie(rating: Double?, reviewCount: Int): String {
    val r = rating ?: return "Нет оценок"
    return when {
        reviewCount < 5 -> "Мало отзывов, рейтинг: $r"
        r >= 8.0 -> "Отличный фильм! ⭐"
        r in 5.0..7.9 -> "Неплохой фильм 🎥"
        else -> "Провал года 💩"
    }
}


fun parseAge(input: String?): Int? {
    val trimmed = input?.trim() ?: return null
    if (trimmed.isEmpty()) return null
    val age = trimmed.toIntOrNull() ?: return null
    return if (age in 0..150) age else null
}

data class Address(val city: String?)
data class User(val name: String, val address: Address?)

fun getCity(user: User?): String = user?.address?.city ?: "Город не указан"

fun main() {
    val u1 = User("Алексей", Address("Москва"))
    val u2 = User("Мария", null)
    val u3: User? = null

    println(getCity(u1))  // "Москва"
    println(getCity(u2))  // "Город не указан"
    println(getCity(u3))  // "Город не указан"
}


