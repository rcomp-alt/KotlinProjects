/*Напиши функцию printMultiplicationTable(n: Int), которая выводит таблицу умножения для n от 1 до 10 через for.

Пример:
text

printMultiplicationTable(3)

Вывод:
text

3 x 1 = 3
3 x 2 = 6
3 x 3 = 9
...
3 x 10 = 30

Подсказка: используй for (i in 1..10) и строковый шаблон.

Пиши — разберем! 😊*/

fun printMultiplicationTable(n: Int, max: Int = 10) {
    for (i in 1..max) {
        println("$n x $i = ${n * i}")
    }
}

fun main() {
    printMultiplicationTable(5)
    println()
    printMultiplicationTable(2,5)
}