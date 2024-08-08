package com.lib.api.Patron;

import java.util.List;
import java.util.Optional;

public interface PatronRepository {
    List<Patron> findAll();

    Optional<Patron> findById(Integer id);

    void save(Patron patron);

    void update(Patron patron, Integer id);

    void deleteById(Integer integer);
}
