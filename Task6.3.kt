data class Product(
    val name: String,
    val price: Double,
    val quantity: Int = 1,
) {
    val totalPrice: Double
        get() = price * quantity
}

fun main() {
    val p1 = Product("Ноутбук", 50000.0, 2)
    val p2 = Product("Ноутбук", 50000.0, 2)

    println(p1)              // Product(name=Ноутбук, price=50000.0, quantity=2)
    println(p1 == p2)        // true
    println(p1.totalPrice)   // 100000.0
    println(p1.copy(quantity = 3).totalPrice)  // 150000.0
}