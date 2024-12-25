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

    @PostMapping
    public Rental createRental(@RequestBody Rental rental) {
        return rentalService.createRental(rental);
    }

}
