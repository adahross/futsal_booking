package futsal.com.futsalbooking.controllers;

import java.io.Console;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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

     @RequestMapping("/api/users")
     public List<User> getAllUsers() {

         return userService.listAll();

     }
     @RequestMapping("/api/courts")
     public List<Court> getAllCourts() {

         return courtService.listAll();

     }

     @RequestMapping(value = "/api/updatecourtstatus/{courtID}")
     public Court updateCourtStatus(@PathVariable("courtID") int id)
     {
         Court court = courtService.get(id);
         if (court.getCourtStat().compareTo("Inactive")==0) {
             courtService.updateCourtStatus(id, "Active");
             court.setCourtStat("Active");
         }
         else if (court.getCourtStat().compareTo("Active") == 0) {
             courtService.updateCourtStatus(id, "Inactive");
             court.setCourtStat("Inactive");
         }
        
         return court;
         
     }
    @RequestMapping("/api/items")
    public List<Item> getAllItems() {
        
        return itemService.listAll();  
        
    }
}