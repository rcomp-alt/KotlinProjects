/*fun gradeForScore(score: Int) = when (score) {
    in 90..100 -> "A"
    in 80..89 -> "B"
    in 70..79 -> "C"
    in 60..69 -> "D"
    in 0..59 -> "F"
    else -> "Некорректный балл"
}*/

fun gradeForScore(score: Int) = when {
    score in 90..100 -> "A"
    score in 80..89 -> "B"
    score in 70..79 -> "C"
    score in 60..69 -> "D"
    score in 0..59 -> "F"
    else -> "Некорректный балл"
}


fun main() {
    println(gradeForScore(95))   // A
    println(gradeForScore(85))   // B
    println(gradeForScore(150))  // Некорректный балл
}