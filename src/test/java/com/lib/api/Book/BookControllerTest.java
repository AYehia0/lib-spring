package com.lib.api.Book;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(BookController.class)
@AutoConfigureMockMvc(addFilters = false) // Disable security filters
class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    @Autowired
    private ObjectMapper objectMapper;

    private List<Book> books = new ArrayList<>();

    @BeforeEach
    void setUp() {
        books.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", "9780743273565", 1925, 5));
        books.add(new Book("To Kill a Mockingbird", "Harper Lee", "9780061120084", 1960, 3));
    }

    @Test
    void getBooks_ReturnsListOfBooks() throws Exception {
        when(bookService.getBooks()).thenReturn(books);

        mockMvc.perform(get("/api/books"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()").value(books.size()));

        verify(bookService, times(1)).getBooks();
    }

    @Test
    void getBookById_ReturnsBook_WhenBookExists() throws Exception {
        Book book = books.get(0);
        when(bookService.getBookById(1)).thenReturn(book);

        mockMvc.perform(get("/api/books/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.title").value(book.title()))
                .andExpect(jsonPath("$.author").value(book.author()));

        verify(bookService, times(1)).getBookById(1);
    }

    @Test
    void getBookById_ReturnsNotFound_WhenBookDoesNotExist() throws Exception {
        when(bookService.getBookById(1)).thenThrow(new BookNotFoundException());

        mockMvc.perform(get("/api/books/{id}", 1))
                .andExpect(status().isNotFound());

        verify(bookService, times(1)).getBookById(1);
    }

    @Test
    void addBook_CreatesNewBook() throws Exception {
        Book newBook = new Book("1984", "George Orwell", "9780451524935", 1949, 4);

        mockMvc.perform(post("/api/books")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newBook)))
                .andExpect(status().isCreated());

        verify(bookService, times(1)).addBook(any(Book.class));
    }

    @Test
    void updateBook_UpdatesExistingBook() throws Exception {
        Book updatedBook = new Book("1984", "George Orwell", "9780451524935", 1949, 5);

        mockMvc.perform(put("/api/books/{id}", 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updatedBook)))
                .andExpect(status().isNoContent());

        verify(bookService, times(1)).updateBook(any(Book.class), eq(1));
    }

    @Test
    void deleteBook_DeletesBook_WhenBookExists() throws Exception {
        mockMvc.perform(delete("/api/books/{id}", 1))
                .andExpect(status().isNoContent());

        verify(bookService, times(1)).deleteBook(1);
    }

    @Test
    void deleteBook_ReturnsNotFound_WhenBookDoesNotExist() throws Exception {
        doThrow(new BookNotFoundException()).when(bookService).deleteBook(1);

        mockMvc.perform(delete("/api/books/{id}", 1))
                .andExpect(status().isNotFound());

        verify(bookService, times(1)).deleteBook(1);
    }

}