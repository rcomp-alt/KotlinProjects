/* Задание 4.3 — расчет скидки

Напиши calculateDiscount(amount: Double, isRegular: Boolean = false): Double:

    Если isRegular и amount > 1000 → скидка 15%

    Если isRegular и amount <= 1000 → скидка 5%

    Если не isRegular и amount > 1000 → скидка 3%

    Иначе → 0%

Верни итоговую сумму (не размер скидки). Используй when и тело-выражение.*/

/*Задание

Напиши консольную программу из трёх функций.
1. calculateTotal
kotlin

fun calculateTotal(amount: Double, isRegular: Boolean, hasPromoCode: Boolean): Double

Что делает:

    Применяет базовую скидку через calculateDiscount(amount, isRegular):

        постоянный + сумма > 1000 → скидка 15%

        постоянный + сумма <= 1000 → скидка 5%

        не постоянный + сумма > 1000 → скидка 3%

        иначе → 0%

    Если hasPromoCode == true → применяет дополнительную скидку 5% от уже скинутой суммы.

    Возвращает итоговую сумму.

    Скидки не суммируются, а применяются последовательно.

2. describeOrder
kotlin

fun describeOrder(total: Double): String

Что делает:

    total >= 10000 → "Крупный заказ"

    total >= 5000 → "Средний заказ"

    иначе → "Малый заказ"

3. printReceipt
kotlin

fun printReceipt(amount: Double, isRegular: Boolean, hasPromoCode: Boolean)

Что делает:

    Вычисляет итог через calculateTotal.

    Определяет тип через describeOrder.

    Выводит строку в формате:
    text

    Сумма: X, Итог: Y, Тип: Z

Пример работы
kotlin

fun main() {
    printReceipt(12000.0, isRegular = true, hasPromoCode = true)
    // Сумма: 12000.0, Итог: 9690.0, Тип: Средний заказ

    printReceipt(800.0, isRegular = false, hasPromoCode = false)
    // Сумма: 800.0, Итог: 800.0, Тип: Малый заказ
}

Требования

    Используй уже написанную calculateDiscount (переиспользуй её, не дублируй логику).

    Все три функции должны быть в одном файле.

    Проверь работу на минимум 4 сценариях (разные комбинации isRegular × hasPromoCode).

Пиши код — разберем! 😊
*/

fun calculateDiscount(amount: Double, isRegular: Boolean = false): Double {
    val discount = when {
        amount > 1000 && isRegular -> 0.15
        isRegular -> 0.05
        amount > 1000 -> 0.03
        else -> 0.0
    }
    return (1 - discount) * amount
}

fun calculateTotal(amount: Double, isRegular: Boolean, hasPromoCode: Boolean): Double {
    val baseAmount = calculateDiscount(amount, isRegular)
    val discount = if (hasPromoCode) 0.05 else 0.0
    return (1.0 - discount) * baseAmount
}

fun describeOrder(total: Double) =
    when {
        total >= 10000 -> "Крупный заказ"
        total >= 5000 -> "Средний заказ"
        else -> "Малый заказ"
    }

fun printReceipt(amount: Double, isRegular: Boolean, hasPromoCode: Boolean) {
    val totalAmount = calculateTotal(amount, isRegular, hasPromoCode)
    println("Сумма: $amount, Итог: $totalAmount, Тип: ${describeOrder(totalAmount)}")
}
/*
fun main() {
    println(calculateDiscount(1200.0, true))   // 1020.0 (скидка 15%)
    println(calculateDiscount(800.0, true))    // 760.0 (скидка 5%)
    println(calculateDiscount(1200.0, false))  // 1164.0 (скидка 3%)
    println(calculateDiscount(500.0, false))   // 500.0 (скидка 0%)
}*/

fun main() {
    printReceipt(12000.0, isRegular = true, hasPromoCode = true)
    // Сумма: 12000.0, Итог: 9690.0, Тип: Средний заказ

    printReceipt(800.0, isRegular = false, hasPromoCode = false)
    // Сумма: 800.0, Итог: 800.0, Тип: Малый заказ
}