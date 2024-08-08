package com.lib.api.Patron;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
● Patron management endpoints:
    ● GET /api/patrons: Retrieve a list of all patrons.
    ● GET /api/patrons/{id}: Retrieve details of a specific patron by ID.
    ● POST /api/patrons: Add a new patron to the system.
    ● PUT /api/patrons/{id}: Update an existing patron's information.
    ● DELETE /api/patrons/{id}: Remove a patron from the system.
*/

@RestController
@RequestMapping("/api/patrons")
public class PatronController {

    private final PatronService patronService;

    public PatronController(PatronService patronService) {
        this.patronService = patronService;
    }

    @GetMapping("")
    List<Patron> getPatrons() {
        return patronService.getPatrons();
    }

    @GetMapping("/{id}")
    Patron getPatronById(@PathVariable Integer id) {
        return patronService.getPatronById(id);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    void addPatron(@Valid @RequestBody Patron patron) {
        patronService.addPatron(patron);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void updatePatron(@Valid @RequestBody Patron patron, @PathVariable Integer id) {
        patronService.updatePatron(patron, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deletePatron(@PathVariable Integer id) {
        patronService.deletePatron(id);
    }
}
