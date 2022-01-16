package com.myblog.app.controller;

import com.myblog.app.model.User;
import com.myblog.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
@Controller
public class MainController {
    @Autowired
    private UserRepository userRepo;


    @GetMapping("/")
    public String viewHomePage() {
        return "login";
    }



    @GetMapping("/login")
    public String myLogin() {
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
if(authentication==null || authentication instanceof AnonymousAuthenticationToken){ return "login";}

//        return "users";
        return "login";
    }


    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());

        return "singup_form";
    }


    @PostMapping("/process_register")
    public String processRegister(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        userRepo.save(user);

        return "home";
    }


    @GetMapping("/home")
    public String mySuccess() {

        return "home";
    }

    @GetMapping("/users")
    public String listUsers(Model model) {
        List<User> listUsers = userRepo.findAll();
        model.addAttribute("listUsers", listUsers);

        return "users";
    }


}
