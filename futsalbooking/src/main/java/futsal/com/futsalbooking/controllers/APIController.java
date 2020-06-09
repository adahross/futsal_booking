package futsal.com.futsalbooking.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import futsal.com.futsalbooking.models.*;
import futsal.com.futsalbooking.services.CourtService;
import futsal.com.futsalbooking.services.ItemService;
import futsal.com.futsalbooking.services.UserService;

@RestController
public class APIController {

    @Autowired
    private UserService userService;
    @Autowired
    private CourtService courtService;
    @Autowired
    private ItemService itemService;

     @RequestMapping("/users")
     public List<User> getAllUsers() {

         return userService.listAll();

     }
     @RequestMapping("/courts")
     public List<Court> getAllCourts() {

         return courtService.listAll();

     }
    @RequestMapping("/items")
    public List<Item> getAllItems() {
        
        return itemService.listAll();  
        
    }
}