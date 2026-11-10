fun safeDivide(a: Int, b: Int) = try {
    "Результат: ${a / b}"
} catch (e: ArithmeticException) {
    "Деление на ноль!"
}

fun parseIntOrThrow(input: String?): Int =
    if (input == null) throw IllegalArgumentException("Входная строка null")
    else input.trim().toIntOrNull() ?: throw NumberFormatException("'$input' не является числом")


fun main() {
    println(parseIntOrThrow("42"))  // 42

    try {
        parseIntOrThrow("abc")
    } catch (e: NumberFormatException) {
        println("Ошибка: ${e.message}")
        // Ошибка: 'abc' не является числом
    }

    try {
        parseIntOrThrow(null)
    } catch (e: IllegalArgumentException) {
        println("Ошибка: ${e.message}")
        // Ошибка: Входная строка null
    }
}