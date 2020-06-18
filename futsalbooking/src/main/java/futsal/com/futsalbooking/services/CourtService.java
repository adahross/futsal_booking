package futsal.com.futsalbooking.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import futsal.com.futsalbooking.models.Court;
import futsal.com.futsalbooking.repositories.CourtRepository;

@Service
@Transactional
public class CourtService {
    
     // DEFINE ALL CRUD OPERATIONS AND RETURN THE APPROPRIATE DATA (LIST, COURT OBJECT, ETC..)
     
  
  @Autowired
    private CourtRepository repo;
     
    public List<Court> listAll() {
        return (List<Court>) repo.findAll();
    }
     
    public void save(Court Court) {
        repo.save(Court);
    }
      public void update(Court Court) {
        repo.save(Court);
    }
     
    public Court get(int id) {
        return repo.findById(id).get();
    }
     
    public void delete(int id) {
        repo.deleteById(id);
    }
    
    public void updateCourtStatus(int id, String status) {
        repo.updateStatus(status, id);
        
    }

}