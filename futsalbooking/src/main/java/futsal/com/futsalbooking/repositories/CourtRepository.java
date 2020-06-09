package futsal.com.futsalbooking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import futsal.com.futsalbooking.models.Court;

public interface CourtRepository extends JpaRepository<Court, Integer> {
    
}