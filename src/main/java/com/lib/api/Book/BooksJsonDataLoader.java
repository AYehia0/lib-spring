package com.lib.api.Book;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Component
public class BooksJsonDataLoader implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(BooksJsonDataLoader.class);
    private final BookRepository bookRepository;
    private final ObjectMapper objectMapper;

    public BooksJsonDataLoader(BookRepository bookRepository, ObjectMapper objectMapper) {
        this.bookRepository = bookRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public void run(String... args) throws Exception {
        if (bookRepository.count() == 0) {
            logger.info("Loading books from JSON file");
            try (InputStream inputStream = getClass().getResourceAsStream("/data/books.json")) {
                Book[] books = objectMapper.readValue(inputStream, Book[].class);
                logger.info("Reading {} books from JSON file", books.length);
                bookRepository.saveAll(List.of(books));
                logger.info("Books loaded successfully");
            } catch (IOException e) {
                logger.error("Error loading books from JSON file", e);
                throw new RuntimeException("Error loading books from JSON file", e);
            }
        }else {
            logger.info("Books already loaded");
        }
    }
}
