package futsal.com.futsalbooking.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import futsal.com.futsalbooking.models.Item;
import futsal.com.futsalbooking.repositories.ItemRepository;

@Service
@Transactional
public class ItemService {
     
     @Autowired
    private ItemRepository repo;
     
    public List<Item> listAll() {
        return (List<Item>) repo.findAll();
    }
     
    public void save(Item item) {
        repo.save(item);
    }
     
    public Item get(int id) {
        return repo.findById(id).get();
    }
     
    public void delete(int id) {
        repo.deleteById(id);
    }
    
}