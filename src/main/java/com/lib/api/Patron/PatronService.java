package com.lib.api.Patron;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatronService {

    private final PatronRepository patronRepository;

    public PatronService(PatronRepository patronRepository) {
        this.patronRepository = patronRepository;
    }

    public List<Patron> getPatrons() {
        return patronRepository.findAll();
    }

    public Patron getPatronById(Integer id) {
        return patronRepository.findById(id)
                .orElseThrow(PatronNotFoundException::new);
    }

    public void addPatron(Patron patron) {
        patronRepository.save(patron);
    }

    public void updatePatron(Patron patron, Integer id) {
        patronRepository.findById(id)
                .orElseThrow(PatronNotFoundException::new);
        patronRepository.update(patron, id);
    }

    public void deletePatron(Integer id) {
        patronRepository.findById(id)
                .orElseThrow(PatronNotFoundException::new);
        patronRepository.deleteById(id);
    }

}
