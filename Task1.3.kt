/*Напиши функцию isEven(n: Int): Boolean, которая возвращает true, если число чётное.
    Используй тело-выражение (=).*/

fun isEven(n:Int): Boolean = n % 2 == 0


fun main(){
    println(isEven(4))  // true
    println(isEven(7))  // false
    println(isEven(0))  // true
}