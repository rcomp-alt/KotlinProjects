
fun validateAge(input: String?): Int {
    val trimmed = input?.trim() ?: throw IllegalArgumentException("Возраст не указан")
    if (trimmed.isEmpty()) throw IllegalArgumentException("Возраст не может быть пустым")
    val age = trimmed.toIntOrNull() ?: throw NumberFormatException("'$input' не является числом")
    if (age < 0) throw IllegalArgumentException("Возраст не может быть отрицательным")
    if (age > 150) throw IllegalArgumentException("Возраст не может быть больше 150")
    return age
}

fun describeAge(age: Int): String =
    when (age) {
        in 0..12 -> "Ребёнок"
        in 13..17 -> "Подросток"
        in 18..64 -> "Взрослый"
        in 65..150 -> "Пенсионер"
        else -> throw IllegalArgumentException("Возраст не может быть отрицательным или больше 150")
    }

fun processAge(input: String?) {
    try {
        val age = validateAge(input)
        println("Возраст: $age (${describeAge(age)})")
    } catch (e: Exception) {
        println("Ошибка: ${e.message}")
    }
}

fun main() {
    processAge("25") // Возраст: 25 (Взрослый)
    processAge("5") // Возраст: 5 (Ребёнок)
    processAge(null) // Ошибка: Возраст не указан
    processAge("abc") // Ошибка: 'abc' не является числом
    processAge("200") // Ошибка: Возраст не может быть больше 150
}
