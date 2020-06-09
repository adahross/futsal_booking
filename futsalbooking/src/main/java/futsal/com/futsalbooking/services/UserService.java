package futsal.com.futsalbooking.services;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import futsal.com.futsalbooking.models.User;
import futsal.com.futsalbooking.repositories.UserRepository;

@Service
@Transactional
public class UserService {
    
     @Autowired
    private UserRepository repo;
     
    public List<User> listAll() {
        return (List<User>) repo.findAll();
    }
     
    public void save(User User) {
        repo.save(User);
    }
     
    public User get(String id) {
        return repo.findById(id).get();
    }
     
    public void delete(String id) {
        repo.deleteById(id);
    }
    
}