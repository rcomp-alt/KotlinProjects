/*Напиши функцию formatPrice(amount: Double, currency: String = "руб."): String,
которая возвращает строку вида "1 234.56 руб.". Округли до 2 знаков после запятой.
*/

    fun formatPrice(amount: Double, currency: String = "руб."): String =
        String.format("%,.2f %s", amount, currency)




fun main(){
    println(formatPrice(1234.56))        // "1 234.56 руб."
    println(formatPrice(500.0))          // "500.00 руб."
    println(formatPrice(1000000.0, "$")) // "1 000 000.00 $
}