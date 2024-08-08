package com.lib.api.Book;


import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/*
The Book Controller should have the following endpoints:
    ● GET /api/books: Retrieve a list of all books.
    ● GET /api/books/{id}: Retrieve details of a specific book by ID.
    ● POST /api/books: Add a new book to the library.
    ● PUT /api/books/{id}: Update an existing book's information.
    ● DELETE /api/books/{id}: Remove a book from the library.
*/

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("")
    List<Book> getBooks() {
        return bookService.getBooks();
    }

    @GetMapping("/{id}")
    Book getBookById(@PathVariable Integer id) {
        return bookService.getBookById(id);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    void addBook(@Valid @RequestBody Book book) {
        bookService.addBook(book);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void updateBook(@Valid @RequestBody Book book, @PathVariable Integer id) {
        bookService.updateBook(book, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteBook(@PathVariable Integer id) {
        bookService.deleteBook(id);
    }

}
