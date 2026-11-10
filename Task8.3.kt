import kotlin.math.pow

enum class Planet(val mass: Double, val radius: Double) {
    EARTH(5.97e24, 6.37e6),
    MARS(6.42e23, 3.39e6),
    VENUS(4.87e24, 6.05e6);

    val G = 6.67e-11

    fun gravity() = G * mass / radius.pow(2)
}

fun main() {
    println(Planet.EARTH.gravity())  // ~9.8
    println(Planet.MARS.gravity())   // ~3.7
    println(Planet.VENUS.gravity())  // ~8.9
}