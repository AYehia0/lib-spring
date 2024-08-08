package com.lib.api.Borrow;

import java.util.List;

public interface BorrowRepository {

    void save(Borrow borrow);

    List<Borrow> findByBorrowsIdAndPatronId(Integer bookId, Integer patronId);

    void update(Borrow borrow);
}
