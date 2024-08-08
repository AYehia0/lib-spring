DROP TABLE IF EXISTS borrows;
DROP TABLE IF EXISTS books;
DROP TABLE IF EXISTS patrons;

DROP INDEX IF EXISTS idx_books_title;
DROP INDEX IF EXISTS idx_patrons_name;


CREATE TABLE books (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    publication_year INT,
    copies INT NOT NULL DEFAULT 1,
    isbn VARCHAR(20) UNIQUE NOT NULL
);

CREATE TABLE patrons (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE borrows (
    id SERIAL PRIMARY KEY,
    book_id INT NOT NULL,
    patron_id INT NOT NULL,
    borrowing_date DATE NOT NULL,
    return_date DATE,
    copies INT NOT NULL DEFAULT 1,
    FOREIGN KEY (book_id) REFERENCES books(id),
    FOREIGN KEY (patron_id) REFERENCES patrons(id)
);

CREATE INDEX idx_books_title ON books(title);
CREATE INDEX idx_patrons_name ON patrons(name);