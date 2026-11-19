enum class Priority(val level: Int, val description: String) {
    LOW(1, "Низкий"),
    MEDIUM(2, "Средний"),
    HIGH(3, "Высокий")
}
        
data class User(
    val id:Int,
    val name: String,
    val tasks: MutableList<Task> = mutableListOf()
)

data class Task(
    val id:Int,
    val title:String,
    
val priority: Priority = Priority.MEDIUM,
    var isDone: Boolean = false
)

class TaskManager{
 private val users = mutableListOf<User>()
    private var nextUserId = 1
    private var nextTaskId = 1

fun addUser(name: String): User {
    val user = User(nextUserId++, name)
    users.add(user)
    return user
}

fun findUser(userId: Int): User = users.find{it.id == userId}?: throw NoSuchElementException("Пользователь с id=$userId не найден.")

fun addTask(userId: Int, title: String, priority: Priority = Priority.MEDIUM): Task{
    val user = findUser(userId)
    val task = Task(nextTaskId++, title, priority)
    user.tasks.add(task)
    return task
}

fun markTaskDone(userId: Int, taskId: Int){
    val user = findUser(userId)
    val task = user.tasks.find{it.id == taskId}?: throw NoSuchElementException("Задача с id=$taskId не найдена")
    if (task.isDone) throw IllegalStateException("Задача с id= $taskId уже выполнена")
    task.isDone = true
    }

fun listUserTasks(userId: Int) {
    val user = findUser(userId)
    if (user.tasks.isEmpty()) {
        println("У пользователя ${user.name} нет задач")
        return
    }
    user.tasks.forEach { println(it) }
}

fun countDoneTasks(userId: Int): Int{
    val user = findUser(userId)
    return user.tasks.count{it.isDone}  
}

fun findTasksByPriority(userId: Int, priority: Priority): List<Task> {
    val user = findUser(userId)
    val result = user.tasks.filter { it.priority == priority }
    if (result.isEmpty()) {
        throw NoSuchElementException("Задачи с приоритетом '$priority' у пользователя не найдены")
    }
    return result
}

}


fun main() {
    val manager = TaskManager()
    
    // 1. Добавление пользователей
    val user1 = manager.addUser("Алексей")
    val user2 = manager.addUser("Мария")
    println(user1)  // User(id=1, name=Алексей, tasks=[])
    
    // 2. Добавление задач
    val task1 = manager.addTask(1, "Купить хлеб")
    val task2 = manager.addTask(1, "Сделать уроки", Priority.HIGH)
    val task3 = manager.addTask(2, "Позвонить маме", Priority.LOW)
    println(task1)  // Task(id=1, title=Купить хлеб, priority=MEDIUM, isDone=false)
    
    // 3. Список задач
    manager.listUserTasks(1)
    // Task(id=1, title=Купить хлеб, priority=MEDIUM, isDone=false)
    // Task(id=2, title=Сделать уроки, priority=HIGH, isDone=false)
    
    // 4. Отметить выполненной
    manager.markTaskDone(1, 1)
    manager.listUserTasks(1)
    // Task(id=1, ..., isDone=true)
    // Task(id=2, ..., isDone=false)
    
    // 5. Количество выполненных
    println(manager.countDoneTasks(1))  // 1
    
    // 6. Поиск по приоритету
    println(manager.findTasksByPriority(1, Priority.HIGH))
    // [Task(id=2, ...)]
    
    // 7. Ошибки
    try {
        manager.findUser(99)
    } catch (e: NoSuchElementException) {
        println("Ошибка: ${e.message}")  // Ошибка: Пользователь с id=99 не найден
    }
    
    try {
        manager.markTaskDone(1, 1)  // уже выполнена
    } catch (e: IllegalStateException) {
        println("Ошибка: ${e.message}")  // Ошибка: Задача с id=1 уже выполнена
    }
    
    try {
        manager.findTasksByPriority(2, Priority.HIGH)  // у Марии нет HIGH
    } catch (e: NoSuchElementException) {
        println("Ошибка: ${e.message}")  // Ошибка: Задачи с приоритетом HIGH не найдены
    }
}