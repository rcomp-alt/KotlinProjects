open class Animal(val name: String) {
    open fun makeSound() = println("...")
    open fun eat() = println("$name ест")
}

class Dog(name: String) : Animal(name) {
    override fun makeSound() = println("$name говорит: Гав-гав!")

    override fun eat() {
        super.eat()
        println("$name виляет хвостом")
    }
}

class Cat(name: String) : Animal(name) {
    override fun makeSound() {
        println("$name говорит: Мяу!")
    }
}

fun describeAnimal(animal: Animal): String = when (animal) {
    is Dog -> "Собака по имени ${animal.name}"
    is Cat -> "Кошка по имени ${animal.name}"
    else -> "Животное по имени ${animal.name}"

}

fun main() {
    val animals: List<Animal> = listOf(Dog("Бобик"), Cat("Мурка"), Animal("Неизвестный"))
    for (animal in animals) {
        println(describeAnimal(animal))
    }
}
// Собака по имени Бобик
// Кошка по имени Мурка
// Животное по имени Неизвестный