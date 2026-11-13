enum class Priority(val level: Int, val description: String){
    LOW(1, "Низкий"),
    MEDIUM(2, "Средний"),
    HIGH(3, "Высокий"),

}

data class Task(
    val id:Int,
    val title: String,
    val prioriy: Priority = Priority.MEDIUM,
    val isDone: Boolean = false    
) 

fun main() {
    val task1 = Task(1, "Купить хлеб")
    val task2 = Task(2, "Сделать уроки", Priority.HIGH)
    val task3 = Task(3, "Позвонить маме", Priority.LOW, isDone = true)
    
    println(task1)  // Task(id=1, title=Купить хлеб, priority=MEDIUM, isDone=false)
    println(task2)  // Task(id=2, title=Сделать уроки, priority=HIGH, isDone=false)
    println(task3)  // Task(id=3, title=Позвонить маме, priority=LOW, isDone=true)
}