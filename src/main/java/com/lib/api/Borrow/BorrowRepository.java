package com.lib.api.Borrow;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface BorrowRepository {

    void save(Borrow borrow);

    List<Borrow> findByBorrowsIdAndPatronId(Integer bookId, Integer patronId);

    void updateBorrowReturnDate(LocalDateTime borrow, Integer bookId, Integer patronId);

    void update(Borrow borrow);
}
