package com.lib.api.Book;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Repository
public class JdbcClientBookRepository implements BookRepository {

    private final JdbcClient jdbcClient;

    public JdbcClientBookRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    // get all books
    public List<Book> findAll() {
        return jdbcClient.sql("SELECT * FROM books")
                .query(Book.class)
                .list();
    }


    // get book by id
    public Optional<Book> findById(Integer id) {
        return jdbcClient.sql("SELECT * FROM books WHERE id = :id")
                .param("id", id)
                .query(Book.class)
                .optional();
    }


    public int count() {
        return jdbcClient.sql("SELECT * FROM books")
                .query()
                .listOfRows()
                .size();
    }

    // add a book
    public void save(Book book) {
        var updated = jdbcClient.sql("INSERT INTO books (title, author, isbn, publication_year, copies) VALUES (?, ?, ?, ?, ?)")
                .params(List.of(book.title(), book.author(), book.isbn(), book.publication_year(), book.copies()))
                .update();

        Assert.state(updated == 1, "Failed to insert book: "+ book.title());
    }

    // update a book
    public void update(Book book, Integer id) {
        var updated = jdbcClient.sql("UPDATE books SET title = ? , author = ?, isbn = ?, publication_year = ?, copies = ? WHERE id = ?")
                .params(List.of(book.title(), book.author(), book.isbn(), book.publication_year(), book.copies(), id))
                .update();

        Assert.state(updated == 1, "Failed to update book with id: "+ id);
    }

    public void updateBookStorage(Integer id, Integer copies) {
        var updated = jdbcClient.sql("UPDATE books SET copies = copies + ? WHERE id = ?")
                .params(List.of(copies, id))
                .update();

        Assert.state(updated == 1, "Failed to update book with id: "+ id);
    }

    public void saveAll(List<Book> books) {
        books.forEach(this::save);
    }

    public void deleteById(Integer id) {
        var updated = jdbcClient.sql("DELETE FROM books WHERE id = :id")
                .param("id", id)
                .update();

        Assert.state(updated == 1, "Failed to delete book with id: "+ id);
    }

    public void deleteAll() {
        jdbcClient.sql("DELETE FROM books")
                .update();

        // reset auto increment
        jdbcClient.sql("ALTER SEQUENCE books_id_seq RESTART WITH 1")
                .update();
    }
}
