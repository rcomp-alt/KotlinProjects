/*Дан список слов:
kotlin

val words = listOf("kotlin", "java", "python", "c", "kotlin", "rust", "java")

Создай новый список, где:

    Слова длиной >= 3

    Все в верхнем регистре

    Без дубликатов

Ожидаемый результат: [KOTLIN, JAVA, PYTHON, RUST]

Подсказки:

    filter { it.length >= 3 } — фильтрация по длине

    map { it.uppercase() } — преобразование в верхний регистр

    distinct() — убирает дубликаты

    Можно объединить в цепочку: words.filter { ... }.map { ... }.distinct()

Но будь внимателен с порядком: если сделать map до distinct, то "kotlin" и "KOTLIN" станут одинаковыми — и distinct их схлопнет. Подумай, в каком порядке лучше.*/


fun main() {
    val words = listOf("kotlin", "java", "python", "c", "kotlin", "rust", "java")

    val newWords = words.filter { it.length > 3 }.map { it.uppercase() }.distinct()

    println(newWords)
}