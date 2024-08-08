package com.lib.api.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository {

    void update(Book book, Integer id);

    void updateBookStorage(Integer id, Integer copies);

    void saveAll(List<Book> books);

    void deleteById(Integer integer);

    Optional<Book> findById(Integer bookId);

    List<Book> findAll();

    void save(Book book);

    int count();
}
