package futsal.com.futsalbooking.services;


import java.sql.SQLException;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.JDBCException;
import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.hibernate.type.TrueFalseType;
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
     
    public User save(User User) throws SQLException, HibernateException{
        
        repo.save(User);
		return User;

        
    }
    public User update(User User){
       
        repo.updateUser(User.getEmail(),User.getPhoneNo(),User.getFullname(),User.getUsername());
		return User;
        
    }
     
    public User get(String id) {
        return repo.findById(id).get();
    }
     
    public void delete(String id) {
        repo.deleteById(id);
    }
    
}