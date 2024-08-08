package com.lib.api.Patron;

import com.lib.api.Book.JdbcClientBookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Repository
public class JdbcClientPatronRepository implements PatronRepository {

    private final JdbcClient jdbcClient;

    public JdbcClientPatronRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }


    // get all books
    public List<Patron> findAll() {
        return jdbcClient.sql("SELECT * FROM patrons")
                .query(Patron.class)
                .list();
    }


    // get book by id
    public Optional<Patron> findById(Integer id) {
        return jdbcClient.sql("SELECT * FROM patrons WHERE id = :id")
                .param("id", id)
                .query(Patron.class)
                .optional();
    }

    // add a patron
    public void save(Patron patron) {
        var updated = jdbcClient.sql("INSERT INTO patrons (name, email, password) VALUES (?, ?, ?)")
                .params(List.of(patron.name(), patron.email(), patron.password()))
                .update();

        Assert.state(updated == 1, "Failed to insert patron: "+ patron.email());
    }

    // update a book
    public void update(Patron patron, Integer id) {
        var updated = jdbcClient.sql("UPDATE patrons SET name = ?, email = ?, password = ? WHERE id = ?")
                .params(List.of(patron.name(), patron.email(), patron.password(), id))
                .update();

        Assert.state(updated == 1, "Failed to update patron with id: "+ id);
    }

    public void deleteById(Integer id) {
        var updated = jdbcClient.sql("DELETE FROM patrons WHERE id = :id")
                .param("id", id)
                .update();

        Assert.state(updated == 1, "Failed to delete patron with id: "+ id);
    }

}
