enum class BookStatus(val description: String) {
    AVAILABLE("В наличии"),
    BORROWED("Выдана"),
    REPAIR("На восстановлении");
}

data class Book(
    val title: String,
    val author: String,
    val year: Int,
    var status: BookStatus = BookStatus.AVAILABLE
)

class Library {
    private val books = mutableListOf<Book>()

    fun addBook(book: Book) {
        val exists = books.any { it.title == book.title && it.author == book.author }
        if (exists) {
            throw IllegalArgumentException("Книга '${book.title} уже есть")
        }
        books.add(book)
    }

    fun borrowBook(title: String) {
        val book = books.find { it.title == title }
        if (book == null) {
            throw NoSuchElementException("Книга '$title' не найдена")
        }
        if (book.status != BookStatus.AVAILABLE) {
            throw IllegalStateException("Книга '${book.title}' не доступна (статус: ${book.status.description})")
        }
        book.status = BookStatus.BORROWED
        println("Книга '${book.title}' выдана")
    }

    fun returnBook(title: String) {
        val book = books.find { it.title == title }
        if (book == null) {
            throw NoSuchElementException("Книга '$title' не найдена")
        }
        if (book.status != BookStatus.BORROWED) {
            throw IllegalStateException("Книга '${book.title}' не была выдана")
        }
        book.status = BookStatus.AVAILABLE
        println("Книга '${book.title}' возвращена")
    }

    fun listBooks() {
        if (books.isEmpty()) {
            println("В библиотеке нет книг.")
            return
        }
        for (book in books) {
            println(book)
        }
    }


    fun findBooksByAuthor(author: String): List<Book> =
    books.filter { it.author == author }
        .ifEmpty { throw NoSuchElementException("Книги автора '$author' не найдены") }
}

fun main() {
    val library = Library()
    library.addBook(Book("Война и мир", "Толстой", 1869))

    try {
        library.addBook(Book("Война и мир", "Толстой", 1869))
    } catch (e: IllegalArgumentException) {
        println("Ошибка: ${e.message}")
        // Ошибка: Книга 'Война и мир' уже есть
    }

    try {
        library.borrowBook("Несуществующая")
    } catch (e: NoSuchElementException) {
        println("Ошибка: ${e.message}")
        // Ошибка: Книга 'Несуществующая' не найдена
    }
}
// Если поиск без учета регистра — 2 книги
// Если с учетом — 0 книг


