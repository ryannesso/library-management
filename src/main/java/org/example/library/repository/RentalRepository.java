package org.example.library.repository;

import org.example.library.model.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Long> {
    Optional<Rental> findByUserIdAndBookId(Long userId, Long bookId);
    List<Rental> findByUserId(Long userId);
    Optional<Rental> findById(Long Id);
}
