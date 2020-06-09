package futsal.com.futsalbooking.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import futsal.com.futsalbooking.models.User;

public interface UserRepository extends JpaRepository<User, String>{


   
}