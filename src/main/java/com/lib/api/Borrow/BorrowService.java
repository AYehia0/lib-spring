package com.lib.api.Borrow;

import com.lib.api.Book.Book;
import com.lib.api.Book.BookNotFoundException;
import com.lib.api.Book.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BorrowService {

    private static final Logger logger = LoggerFactory.getLogger(BorrowService.class);
    private final BorrowRepository borrowRepository;
    private final BookRepository bookRepository;

    public BorrowService(BorrowRepository borrowRepository, BookRepository bookRepository) {
        this.borrowRepository = borrowRepository;
        this.bookRepository = bookRepository;
    }

    @Transactional
    public void borrowBook(Integer bookId, Integer patronId) {
        int MAX_BORROWED_BOOKS = 1;

        Optional<Book> book = bookRepository.findById(bookId);

        if (book.isEmpty() || book.get().copies() == 0) {
            throw new BookNotFoundException();
        }

        // check if the book is borrowed by the patron
        List<Borrow> borrowedBooks = borrowRepository.findByBorrowsIdAndPatronId(bookId, patronId);

        if (borrowedBooks.size() > MAX_BORROWED_BOOKS) {
            throw new BorrowConflictException();
        }

        var borrowingDate = java.time.LocalDate.now();

        Borrow newBorrow = new Borrow(null, patronId, bookId, borrowingDate, null, 1);

        borrowRepository.save(newBorrow);

        bookRepository.updateBookStorage(bookId, -1);
    }

    @Transactional
    public void returnBook(Integer bookId, Integer patronId) {

        // check if the book is borrowed by the patron
        List<Borrow> borrowedBooks = borrowRepository.findByBorrowsIdAndPatronId(bookId, patronId);

        logger.info("borrowedBooks: " + borrowedBooks.toString());

        if (borrowedBooks.isEmpty() || borrowedBooks.get(0).return_date() != null) {
            throw new BorrowConflictException();
        }

        // update the borrow
        var newBorrow = new Borrow(
                borrowedBooks.get(0).id(),
                patronId,
                bookId,
                borrowedBooks.get(0).borrowing_date(),
                java.time.LocalDate.now(),
                borrowedBooks.get(0).copies()
        );

        borrowRepository.update(newBorrow);

        // update the book copies
        bookRepository.updateBookStorage(bookId, 1);

    }
}
