package com.lib.api.Book;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class BookServiceTest {
    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getBooks_ReturnsListOfBooks() {
        List<Book> books = List.of(new Book("Book 1", "Author 1", "ISBN1", 2021, 5));

        when(bookRepository.findAll()).thenReturn(books);

        List<Book> result = bookService.getBooks();

        assertEquals(books, result);
    }

    @Test
    void getBookById_ExistingId_ReturnsBook() {
        Book book = new Book("Book 1", "Author 1", "ISBN1", 2021, 5);

        when(bookRepository.findById(1)).thenReturn(Optional.of(book));

        Book result = bookService.getBookById(1);

        assertEquals(book, result);
        verify(bookRepository, times(1)).findById(1);
    }

    @Test
    void getBookById_NonExistingId_ThrowsException() {
        when(bookRepository.findById(1)).thenReturn(Optional.empty());

        assertThrows(BookNotFoundException.class, () -> bookService.getBookById(1));
        verify(bookRepository, times(1)).findById(1);
    }

    @Test
    void addBook_SavesBook() {
        Book book = new Book("Book 1", "Author 1", "ISBN1", 2021, 5);

        bookService.addBook(book);

        verify(bookRepository, times(1)).save(book);
    }

    @Test
    void updateBook_ExistingId_UpdatesBook() {
        Book book = new Book("Book 1", "Author 1", "ISBN1", 2021, 5);

        when(bookRepository.findById(1)).thenReturn(Optional.of(book));

        bookService.updateBook(book, 1);

        verify(bookRepository, times(1)).update(book, 1);
    }

    @Test
    void updateBook_NonExistingId_ThrowsException() {
        Book book = new Book("Book 1", "Author 1", "ISBN1", 2021, 5);

        when(bookRepository.findById(1)).thenReturn(Optional.empty());

        assertThrows(BookNotFoundException.class, () -> bookService.updateBook(book, 1));
        verify(bookRepository, never()).update(book, 1);
    }

    @Test
    void deleteBook_ExistingId_DeletesBook() {
        Book book = new Book("Book 1", "Author 1", "ISBN1", 2021, 5);

        when(bookRepository.findById(1)).thenReturn(Optional.of(book));

        bookService.deleteBook(1);

        verify(bookRepository, times(1)).deleteById(1);
    }

    @Test
    void deleteBook_NonExistingId_ThrowsException() {
        when(bookRepository.findById(1)).thenReturn(Optional.empty());

        assertThrows(BookNotFoundException.class, () -> bookService.deleteBook(1));
        verify(bookRepository, never()).deleteById(1);
    }
}