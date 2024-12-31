package org.example.library.controller;


import org.example.library.model.Rental;
import org.example.library.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rentals")
public class RentalController {

    @Autowired
    private RentalService rentalService;

    @GetMapping("/user/{userId}")
    public List<Rental> getRentalsByUserId(@PathVariable Long userId) {
        return rentalService.getRentalsByUserId(userId);
    }

    @PostMapping("/rental")
    public Rental createRental(@RequestBody Rental rental) {
        return rentalService.createRental(rental);
    }

    @PutMapping("/return")
    public Rental returnRental(@RequestBody Rental rental) {
        return rentalService.returnRental(rental);
    }

    @DeleteMapping("/rental/delete/{id}")
    public void deleteRental(@PathVariable Long id) {
        rentalService.deleteRental(id);
    }

}
