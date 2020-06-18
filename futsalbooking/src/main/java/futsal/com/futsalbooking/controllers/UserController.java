package futsal.com.futsalbooking.controllers;

import java.sql.SQLException;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.hibernate.exception.DataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import futsal.com.futsalbooking.models.User;
import futsal.com.futsalbooking.repositories.UserRepository;
import futsal.com.futsalbooking.services.UserService;

//import futsal.com.futsalbooking.repositories.UserRepository;

@Controller
public class UserController {

  //DEFINE SERVICE TO RETREIVE DATA FROM USERREPOSITORY.JAVA
  @Autowired
  private UserService userService;

  //GET ALL USERS AND DISPLAY THE LISTS IN index-user.html

  @GetMapping("/users")
  public String index(Model model) {
    model.addAttribute("users", userService.listAll());
    return "index-user";
  }

  // public String IndexUser(Model model) {
  // model.addAttribute("users", userRepository.getAllUser());
  // return "index-user";
  // }

  //DISPLAY ADD USER FORM

  @GetMapping("/signup")
  public String showSignUpForm(User user) {

    return "add-user";
  }
  

  //POST - ADD USER INTO DATABASE
  @PostMapping("/adduser")
  public String addUser(@Valid User user, BindingResult result, Model model, RedirectAttributes redirectAttributes) {
    if (result.hasErrors()) {
      model.addAttribute("user", user);
      return "add-user";
    }

    try {
      user.setUsertype(0);
      userService.save(user);
      model.addAttribute("users", userService.listAll());
      return "redirect:/users";
    }

    catch (Exception e) {
      model.addAttribute("user", user);
      redirectAttributes.addFlashAttribute("message", "Email has been taken");
      redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
      return "redirect:/signup";
    }

  }

  //GET - GET USER VIA USERNAME DISPLAY USER FORM EDIT IN UPDATE-USER.HTML
  @GetMapping("/edit/{username}")
  public String showUpdateForm(@PathVariable("username") String id, Model model) {

    model.addAttribute("user", userService.get(id));
    return "update-user";
  }

  //POST - UPDATE USER INFO IN DATABASE
  @PostMapping("/update/{username}")
  public String updateUser(@PathVariable("username") String id, @Valid User user, BindingResult result, Model model,
      RedirectAttributes redirectAttributes) {
    if (result.hasErrors()) {
      user.setUsername(id);
      return "update-user";
    }
    User editUser = userService.get(id);
    editUser.setEmail(user.getEmail());
    editUser.setPhoneNo(user.getPhoneNo());
    editUser.setFullname(user.getFullname());
    userService.update(user);
    model.addAttribute("users", userService.listAll());
    return "redirect:/users";
  }

  //GET - GET USER VIA USERNAME DISPLAY USER INFORMATION IN VIEW-USER.HTML
  @GetMapping("/view/{username}")
  public String viewUser(@PathVariable("username") String id, Model model) {
    model.addAttribute("user", userService.get(id));
    return "view-user";
  }

  //DELETE USER VIA USERNAME
  @GetMapping("/delete/{username}")
  public String deleteUser(@PathVariable("username") String id, Model model) {
    userService.delete(id);
    model.addAttribute("users", userService.listAll());
    return "redirect:/users";
  }

}