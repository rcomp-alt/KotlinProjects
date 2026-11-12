/*Задание 12.1. describeValue (15 минут)

Напиши функцию describeValue(value: Any): String:

String → "Строка: '$value' (длина: ${value.length})"

Int → "Число: $value (квадрат: ${value * value})"

Double → "Дробное: $value"

Boolean → "Булево: $value"

List<*> → "Список из ${value.size} элементов"

иначе → "Неизвестный тип: $value"

Требования: используй when с is (умное преобразование).*/

fun describeValue(value: Any): String =
    when (value) {
        is String -> "Строка: '$value' (длина: ${value.length})"
        is Int -> "Число: $value (квадрат: ${value * value})"
        is Double -> "Дробное: $value"
        is Boolean -> "Булево: $value"
        is List<*> -> "Список из ${value.size} элементов" // * — потому что тип элементов неизвестен (List<Int> не является List<Any>)
        else -> "Неизвестный тип: $value"
    }

fun safeCast(value: Any?): String = value as? String ?: "Не строка"

fun processItem(item: Any): String =
    when (item) {
        is Book -> "Книга: ${item.title} (${item.author})"
        is Int -> if (item > 0) "Положительное число: $item" else "Отрицательное число: $item"
        is String -> if (item.isEmpty()) "Пустая строка" else "Строка: $item"
        else -> "Неизвестный элемент"
    }


fun main() {
    println(processItem(Book("Война и мир", "Толстой", 1869)))
    // Книга: Война и мир (Толстой)

    println(processItem(42))     // Положительное число: 42
    println(processItem(-5))     // Отрицательное число: -5
    println(processItem(""))     // Пустая строка
    println(processItem("Hello"))// Строка: Hello
}
