package com.myblog.app.controller;

import com.myblog.app.model.Text;
import com.myblog.app.model.User;
import com.myblog.app.repository.TextRepository;
import com.myblog.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
@Controller
public class MainController {
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private TextRepository textRepo;

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


    @PostMapping("/process_addText")
    public String processAddText(User user,Text text) {
        textRepo.save(text);


        return "home";
    }


    @GetMapping("/home")
    public String mySuccess(Model model) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();

        User posts=userRepo.findByEmail(name);
        model.addAttribute("myid",posts.getId());
        return "home";
    }

    @GetMapping("/users")
    public String listUsers(Model model) {
        List<User> listUsers = userRepo.findAll();
        model.addAttribute("listUsers", listUsers);

        return "users";
    }


//    @GetMapping("/home/{id}/edit")
//    public String blogEdit(@PathVariable(value="id") long id, Model model){
//        Optional<Post> post= postRepository.findById(id);
//        ArrayList<Post> res= new ArrayList<>();
//        post.ifPresent(res::add);
//        model.addAttribute("post",res);
//        return "blog-edit";
//    }
//



}
