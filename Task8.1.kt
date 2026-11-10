enum class OrderStatus(val description: String) {
    PENDING("Ожидает обработки"),
    SHIPPED("Отправлен"),
    DELIVERED("Доставлен"),
    CANCELLED("Отменен");

    val isFinal: Boolean
        get() = when (this) {
            DELIVERED, CANCELLED -> true
            PENDING, SHIPPED -> false
        }

    fun describeStatus(): String = when (this) {
        PENDING -> "Заказ ожидает обработки"
        SHIPPED -> "Заказ в пути"
        DELIVERED -> "Заказ доставлен"
        CANCELLED -> "Заказ отменен"
    }
}

fun main() {
    println(OrderStatus.PENDING.describeStatus())    // "Ожидает обработки"
    println(OrderStatus.DELIVERED.describeStatus())    // true
    println(OrderStatus.SHIPPED.describeStatus())      // false
    println(OrderStatus.CANCELLED.describeStatus())    // true
}