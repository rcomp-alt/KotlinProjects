data class BankAccount(
    val owner: String,
    var balance: Double = 0.0,
) {
    fun deposit(amount: Double) {
        balance += amount
    }

    fun withdraw(amount: Double) {
        if (amount <= balance) {
            balance -= amount
        } else {
            println("Недостаточно средств")
        }
    }

    fun showBalance() = println("Баланс: $balance")
}

fun main() {
    val a1 = BankAccount("Алексей", 1000.0)
    val a2 = BankAccount("Алексей", 1000.0)

    println(a1)        // BankAccount(owner=Алексей, balance=1000.0)
    println(a1 == a2)  // true
    println("Алексей ")
}