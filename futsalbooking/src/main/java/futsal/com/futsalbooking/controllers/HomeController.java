package futsal.com.futsalbooking.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import futsal.com.futsalbooking.models.User;
import futsal.com.futsalbooking.services.UserService;

/**
 * @author Jerry Conde, webmaster@javapointers.com
 * @since 8/9/2016
 */
@Controller
public class HomeController {
    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String viewHome() {
        return "index";
    }
//    @RequestMapping("/signup")
//    public String showSignUpForm() {
//        return "add-user";
//    }
    
//    @PostMapping("/register")
//    public User SignUp(@RequestBody User user) {

//        user.setUsertype(0);
//        User u = userService.get(user.getUsername());
//        if(u==null)
//            return u;
//        else

//        return user;
//     }
}
