package com.myblog.app.controller;

import com.myblog.app.model.User;
import com.myblog.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

public class MainController {
    @Autowired
    private UserRepository userRepo;

    @GetMapping("")
    public String viewHomePage(Model model) {
        return "login";
    }




//    @GetMapping("/login")
//    public String myLogin() {
//        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
//        if(authentication==null || authentication instanceof AnonymousAuthenticationToken){ return "login";}
//
////        return "users";
//        return "login";
//    }
//
//    @GetMapping("/register_success")
//    public String mySuccess() {
//
//        return "register_success";
//    }



}
