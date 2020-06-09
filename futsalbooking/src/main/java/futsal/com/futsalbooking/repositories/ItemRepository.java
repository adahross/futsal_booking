package futsal.com.futsalbooking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import futsal.com.futsalbooking.models.Item;

public interface ItemRepository extends JpaRepository<Item,Integer> {
    
}