package org.example.library.service;


import org.example.library.model.Rental;
import org.example.library.repository.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalService {

    @Autowired
    private RentalRepository rentalRepository;

    public List<Rental> getRentalsByUserId(Long userId) {
        return rentalRepository.findByUserId(userId);
    }

    public Rental createRental(Rental rental) {
        return rentalRepository.save(rental);
    }

}
