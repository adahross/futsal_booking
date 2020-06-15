package futsal.com.futsalbooking.repositories;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import futsal.com.futsalbooking.models.User;

public interface UserRepository extends JpaRepository<User, String>{

 @Transactional
    @Modifying
    @Query(value = "UPDATE user u set email =:email, phoneNo=:phoneNo, fullname=:fullname  where u.username = :username",
            nativeQuery = true)
void updateUser(@Param("email") String email,@Param("phoneNo") String phoneNo,@Param("fullname") String fullname, @Param("username") String userId);
   
}