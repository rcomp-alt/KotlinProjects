enum class Priority(val level: Int, val description: String){
    LOW(1, "Низкий"),
    MEDIUM(2, "Средний"),
    HIGH(3, "Высокий"),

}

data class Task(
    val id:Int,
    val title: String,
    val priority: Priority = Priority.MEDIUM,
    val isDone: Boolean = false    
)

class TaskList{
        private val tasks = mutableListOf<Task>()
    private var nextId = 1
    fun add(
    title: String,
    priority:Priority = Priority.MEDIUM): Task
    {
    val task = Task(
        nextId++,
        title,
        priority)
    tasks.add(task)
    return task
    }

    fun listAll() = tasks.forEach {println(it)}

    fun findById(id: Int): Task {
        val task = tasks.find { it.id == id }
        return task?:throw NoSuchElementException("Задание с id = $id не найдено.")
    }
    fun printTasks() = println(tasks.filter { it.priority == Priority.HIGH})

    fun listByPriority(priority: Priority): List<Task> {
    val list = tasks.filter { it.priority == priority }
    if (list.isNotEmpty()) return list
    else throw NoSuchElementException("Заданий с приоритетом $priority не найдено.")
} 
    


}

fun main() {

    val taskList = TaskList()
    taskList.add("Task1")
    taskList.add("Task2", priority = Priority.MEDIUM)
    taskList.add("Task3", priority = Priority.LOW)
    taskList.add("Task4", priority = Priority.LOW)
    taskList.listAll()
    //println(taskList.findById(3))
    println(taskList.listByPriority((Priority.HIGH)))
    //taskList.printTasks()
    /*println(task1)  // Task(id=1, title=Купить хлеб, priority=MEDIUM, isDone=false)
    println(task2)  // Task(id=2, title=Сделать уроки, priority=HIGH, isDone=false)
    println(task3)  // Task(id=3, title=Позвонить маме, priority=LOW, isDone=true)*/
}