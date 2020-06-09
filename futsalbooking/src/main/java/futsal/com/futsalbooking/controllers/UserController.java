package futsal.com.futsalbooking.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import futsal.com.futsalbooking.models.User;
import futsal.com.futsalbooking.repositories.UserRepository;
import futsal.com.futsalbooking.services.UserService;

//import futsal.com.futsalbooking.repositories.UserRepository;

@Controller
public class UserController {

      @Autowired
    private UserService userService;
    

    private UserRepository userRepository;

     @GetMapping("/viewusers")
    public String index(Model model) {
      model.addAttribute("users", userService.listAll());
        return"index-user";  
    }  

    
    // public String IndexUser(Model model) {
    //     model.addAttribute("users", userRepository.getAllUser());
    //     return "index-user";
    // }

     @GetMapping("/signup")
     public String showSignUpForm(User user) {
       
         return "add-user";
     }
     
     @PostMapping("/adduser")
     public String addUser(@Valid User user, BindingResult result, Model model) {
       if (result.hasErrors()) {
         return "add-user";
       }
    
        user.setUsertype(0);
        userService.save(user);;
        model.addAttribute("users", userService.listAll());
        return "index-user";
    }
    
    @GetMapping("/edit/{username}")
    public String showUpdateForm(@PathVariable("username") String id, Model model) {
      
        model.addAttribute("user", userService.get(id));
        return "update-user";
    }

    @PostMapping("/update/{username}")
    public String updateUser(@PathVariable("username") String id, @Valid User user, BindingResult result, Model model) {
    if (result.hasErrors()) {
        user.setUsername(id);
        return "update-user";
    }
         
    userService.save(user);
    model.addAttribute("users", userRepository.findAll());
    return "index-user";
}
     
@GetMapping("/delete/{username}")
public String deleteUser(@PathVariable("username") String id, Model model) {
  userService.delete(id);
  model.addAttribute("users", userService.listAll());
    return "index-user";
}
 
}