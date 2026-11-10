data class Student(
    val name: String,
    val age: Int,
    val averageGrade: Double,
) {
    fun introduce() = println(
        "Привет, меня зовут $name, мне $age лет, средний балл: $averageGrade"
    )
}

fun main() {
    val s1 = Student("Алексей", 20, 4.7)
    val s2 = Student("Алексей", 20, 4.7)

    println(s1)           // Student(name=Алексей, age=20, averageGrade=4.7)
    println(s1 == s2)     // true
    val s3 = s1.copy(age = 21)
    println(s3)  // Student(name=Алексей, age=21, averageGrade=4.7)
    println(s1 == s3) //false
    val s4 = s3.copy()
    println(s4)
    println(s3 == s4)
}