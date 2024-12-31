package org.example.library.service;


import org.example.library.model.Book;
import org.example.library.model.Rental;
import org.example.library.model.User;
import org.example.library.repository.BookRepository;
import org.example.library.repository.RentalRepository;
import org.example.library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RentalService {

    @Autowired
    private RentalRepository rentalRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private UserRepository userRepository;

    public List<Rental> getRentalsByUserId(Long userId) {
        return rentalRepository.findByUserId(userId);
    }

    public Rental createRental(Rental rental) {

        User user = userRepository.findById(rental.getUser().getId())
                .orElseThrow(() -> new RuntimeException("user nof found"));
        Book book = bookRepository.findById(rental.getBook().getId())
                .orElseThrow(() -> new RuntimeException("book nof found"));

        rental.setUser(user);
        rental.setBook(book);
        rental.setRentalDate(LocalDateTime.now());
        book.setAvailable(false);

        return rentalRepository.save(rental);
    }

    public Rental returnRental(Rental rental) {

        Rental existingRental = rentalRepository.findByUserIdAndBookId(
                rental.getUser().getId(),
                rental.getBook().getId()
        ).orElseThrow(() -> new RuntimeException("Rental not found"));

        existingRental.setReturnDate(LocalDateTime.now());
        existingRental.getBook().setAvailable(true);

        return rentalRepository.save(existingRental);
    }

    public void deleteRental(Long rentalId) {
        rentalRepository.deleteById(rentalId);
    }


}
