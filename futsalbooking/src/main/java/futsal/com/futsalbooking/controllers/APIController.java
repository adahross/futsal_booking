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


    // DEFINED ALL SERVICES TO RETRIVE DATA FROM REPOSITORY
	@Autowired
    private UserService userService;
    @Autowired
    private CourtService courtService;
    @Autowired
    private ItemService itemService;



    ///GET LIST OF USERS *NOT IMPLEMENTED IN THE PROJECT HOWEVER THE API CAN BE ACCESS THROUGH http://localhost:8085/futsalbooking/api/users
     @RequestMapping("/api/users")
     public List<User> getAllUsers() {

         return userService.listAll();

     }

     ///GET LIST OF COURT IMPLEMENTED IN HOMEPAGE TO DISPLAY AVAILABLE COURT. REFER TO APP.JS
     @RequestMapping("/api/courts")
     public List<Court> getAllCourts() {

         return courtService.listAll();

     }

     ///UPDATE THE COURT STATUS VIA ID IMPLEMENTED IN INDEX COURT PAGE. REFER TO APP.JS
      
     
     @RequestMapping(value = "/api/updatecourtstatus/{courtID}")
     public Court updateCourtStatus(@PathVariable("courtID") int id)
     {
         Court court = courtService.get(id);
         if (court.getCourtStat().compareTo("Inactive") == 0) {
             courtService.updateCourtStatus(id, "Active");
             court.setCourtStat("Active");
         } else if (court.getCourtStat().compareTo("Active") == 0) {
             courtService.updateCourtStatus(id, "Inactive");
             court.setCourtStat("Inactive");
         }

         return court;

     }
     
     ///GET LISTS OF ITEM. *NOT IMPLEMENTED IN THE PROJECT HOWEVER THE API CAN BE ACCESS THROUGH http://localhost:8085/futsalbooking/api/items
    //
    @RequestMapping("/api/items")
    public List<Item> getAllItems() {
        
        return itemService.listAll();  
        
    }
}