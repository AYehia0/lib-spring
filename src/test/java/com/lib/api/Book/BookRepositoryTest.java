package com.lib.api.Book;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.JdbcConnectionDetails;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@Testcontainers
@DataJdbcTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import(JdbcClientBookRepository.class)
class BookRepositoryTest {

    @Container
    @ServiceConnection
    public static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>(DockerImageName.parse("postgres:latest"));

    @Autowired
    private JdbcClientBookRepository bookRepository;

    @Autowired
    JdbcConnectionDetails jdbcConnectionDetails;

    @BeforeAll
    static void setUp() {
        // check if the connection to the container is up and running
        postgres.start();

        assertThat(postgres.isCreated()).isTrue();
        assertThat(postgres.isRunning()).isTrue();
    }

    @AfterAll
    static void tearDown() {
        postgres.stop();
    }

    @BeforeEach
    void cleanUp() {
        bookRepository.deleteAll();
    }

    @DynamicPropertySource
    static void configureProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgres::getJdbcUrl);
        registry.add("spring.datasource.username", postgres::getUsername);
        registry.add("spring.datasource.password", postgres::getPassword);
    }

    @Test
    void save() {
        Book book = new Book("The Great Gatsby", "F. Scott Fitzgerald", "9780743273565", 1925, 5);

        bookRepository.save(book);
        var count = bookRepository.count();

        assertThat(count).isEqualTo(1);
    }

    @Test
    void findById() {
        Book book = new Book("The Great Gatsby", "F. Scott Fitzgerald", "9780743273562", 1925, 5);

        bookRepository.save(book);

        Optional<Book> savedBook = bookRepository.findById(1);
        if (!savedBook.isPresent()) {
            throw new RuntimeException("Book not found");
        }

        assertThat(savedBook.get()).isEqualTo(book);
    }

    @Test
    void update() {
        Book book = new Book("The Great Gatsby", "F. Scott Fitzgerald", "9780743223562", 1925, 5);

        bookRepository.save(book);

        Book updatedBook = new Book("The Not Great Gatsby", "F. Scott Fitzgerald", "9780743223562", 1925, 10);
        bookRepository.update(updatedBook, 1);

        Optional<Book> savedBook = bookRepository.findById(1);
        if (!savedBook.isPresent()) {
            throw new RuntimeException("Book not found");
        }

        assertThat(savedBook.get()).isEqualTo(updatedBook);
    }

    @Test
    void updateBookStorage() {
        Book book = new Book("The Great Gatsby", "F. Scott Fitzgerald", "9780743173562", 1925, 5);

        bookRepository.save(book);

        bookRepository.updateBookStorage(1, 5);

        Optional<Book> savedBook = bookRepository.findById(1);
        if (!savedBook.isPresent()) {
            throw new RuntimeException("Book not found");
        }

        assertThat(savedBook.get().copies()).isEqualTo(10);
    }

    @Test
    void deleteById() {
        Book book = new Book("The Great Gatsby", "F. Scott Fitzgerald", "9781743273562", 1925, 5);

        bookRepository.save(book);

        bookRepository.deleteById(1);

        var bookById = bookRepository.findById(1);

        assertThat(bookById).isEmpty();
    }

    @Test
    void findAll() {
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "9780743273569", 1925, 5);
        Book book2 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "9780743273568", 1925, 5);

        bookRepository.save(book1);
        bookRepository.save(book2);

        var books = bookRepository.findAll();

        assertThat(books.size()).isEqualTo(2);
    }

    @Test
    void saveAll() {
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "9780743273512", 1925, 5);
        Book book2 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "9780743273212", 1925, 5);

        bookRepository.saveAll(List.of(book1, book2));

        var books = bookRepository.findAll();

        assertThat(books.size()).isEqualTo(2);
    }

}