fun main(){
    print("Введите первое число: ")
    val x = readln().toDouble()
    print("Введите второе число: ")
    val y = readln().toDouble()
    print("Введите арифметическую операцию в виде +, -, *, / : ")
    val op = readln()
    require(op != "/" || y != 0.0) { "Делитель не может быть нулём" }
    print("Результат: ${calculate(x, y, op)}")
}

fun calculate(a:Double, b:Double, operation:String) : Double{
    return when (operation){
        "+" -> a + b
        "-" -> a - b
        "*" -> a * b
        "/" -> a / b
        else -> 0.0
    }
}
