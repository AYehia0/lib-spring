package com.lib.api.Book;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Integer id) {
        return bookRepository.findById(id)
                .orElseThrow(BookNotFoundException::new);
    }

    public void addBook(Book book) {
        bookRepository.save(book);
    }

    public void updateBook(Book book, Integer id) {
        bookRepository.findById(id)
                .orElseThrow(BookNotFoundException::new);

        bookRepository.update(book, id);
    }

    public void deleteBook(Integer id) {
        bookRepository.findById(id)
                .orElseThrow(BookNotFoundException::new);
        bookRepository.deleteById(id);
    }

}