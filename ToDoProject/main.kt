enum class Priority(val level: Int, val description: String){
    LOW(1, "Низкий"),
    MEDIUM(2, "Средний"),
    HIGH(3, "Высокий"),

}

data class Task(
    val id:Int,
    val title: String,
    val priority: Priority = Priority.MEDIUM,
    var isDone: Boolean = false    
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
    return task ?: throw NoSuchElementException("Задание с id = $id не найдено.")
}

    //fun printTasks() = println(tasks.filter { it.priority == Priority.HIGH})

  fun listByPriority(priority: Priority): List<Task> {
    val list = tasks.filter { it.priority == priority }
    if (list.isEmpty()) {
        throw NoSuchElementException("Заданий с приоритетом '${priority.description}' не найдено.")
    }
    return list
}

fun markDone(id: Int){
    val task = findById(id)
    if (task.isDone) throw IllegalStateException("Задача с id=$id уже выполнена")
    task.isDone = true
}
    
fun remove(id: Int) = tasks.remove(findById(id))

fun listByStatus(isDone: Boolean): List<Task> {
        val list = tasks.filter { it.isDone == isDone }
    if (list.isEmpty()) {
        throw NoSuchElementException("Задачи с isDone=$isDone не найдены")
    }
    return list
}

fun countByPriority(priority: Priority): Int = tasks.count { it.priority == priority }

}

fun main() {
    val taskList = TaskList()
    taskList.add("Купить хлеб")                    // MEDIUM
    taskList.add("Сделать уроки", Priority.HIGH)   // HIGH
    taskList.add("Позвонить маме", Priority.HIGH)  // HIGH
    println(taskList.countByPriority(Priority.HIGH))    // 2 ✅
    println(taskList.countByPriority(Priority.LOW))     // 0 ✅
}