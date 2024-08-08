package com.lib.api.Borrow;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class JdbcClientBorrowRepository implements BorrowRepository {

    private final JdbcClient jdbcClient;

    public JdbcClientBorrowRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    // add a borrow
    public void save(Borrow borrow) {
        var updated = jdbcClient.sql("INSERT INTO borrows (book_id, patron_id, borrowing_date, copies) VALUES (?, ?, ?, ?)")
                .params(List.of(borrow.book_id(), borrow.patron_id(), borrow.borrowing_date(), borrow.copies()))
                .update();

        Assert.state(updated == 1, "Failed to insert borrow: "+ borrow.patron_id());
    }

    // get borrow by bookId and patronId
    public List<Borrow> findByBorrowsIdAndPatronId(Integer bookId, Integer patronId) {
        return jdbcClient.sql("SELECT * FROM borrows WHERE book_id = ? AND patron_id = ?")
                .params(List.of(bookId, patronId))
                .query(Borrow.class)
                .list();
    }

    public void updateBorrowReturnDate(LocalDateTime returnDate, Integer bookId, Integer patronId) {
        var updated = jdbcClient.sql("UPDATE borrows SET return_date = ? WHERE book_id = ? AND patron_id = ?")
                .params(List.of(returnDate, bookId, patronId))
                .update();

        Assert.state(updated == 1, "Failed to update borrow: "+ patronId);
    }

    public void update(Borrow borrow) {
        var updated = jdbcClient.sql("UPDATE borrows SET book_id = ?, patron_id = ?, borrowing_date = ?, return_date = ?, copies = ? WHERE id = ?")
                .params(List.of(borrow.book_id(), borrow.patron_id(), borrow.borrowing_date(), borrow.return_date(), borrow.copies(), borrow.id()))
                .update();

        Assert.state(updated == 1, "Failed to update borrow: "+ borrow.id());
    }

}