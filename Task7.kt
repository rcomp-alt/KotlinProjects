data class Students(val name: String, val age: Int)

fun main() {
    val s1 = Students("Алексей", 20)
    val s2 = Students("Алексей", 20)

    println(s1)        // Student@1b6d3586 (бесполезно!)
    println(s1 == s2)  // false (сравнение по ссылкам!)
}