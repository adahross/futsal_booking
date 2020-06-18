package futsal.com.futsalbooking.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import futsal.com.futsalbooking.models.Court;

//INHERIT THE COURT REPOSITORY WITH JPA REPOSITORY WHICH CONSIST OF PREDEFINED METHOD FOR CRUD OPERATION

public interface CourtRepository extends JpaRepository<Court, Integer> {
    

    @Transactional
    @Modifying
    @Query(value = "UPDATE court c set courtStat =:courtStat where c.courtID = :courtID",
            nativeQuery = true)

    //DEFINE NATIVE QUERY FOR UPDATE STATUS FOR COURT.
    void updateStatus(@Param("courtStat") String courtStat, @Param("courtID") int courtID);
}