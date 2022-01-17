package com.myblog.app.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
@Controller
public class MainController {
    private static final Logger LOGGER=LoggerFactory.getLogger(MainController.class);

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
        model.addAttribute("user9", new User());

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


//    @PostMapping("/process_addText")
//    public String processAddText(@ModelAttribute  Text text1) {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        String name = auth.getName();
//        User myUser=userRepo.findByEmail(name);
//
//       text1.setUser(myUser);
////        text1.setText("sfqsfdsqdf");
//
//        textRepo.save(text1);
//
//
//        return "redirect:/home";
//    }



    @PostMapping("/process_addText")
    public String processAddText(String text) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        User myUser=userRepo.findByEmail(name);


        Text myTextInstance=new Text();
        myTextInstance.setText(text);
        myTextInstance.setUser(myUser);

        textRepo.save(myTextInstance);

        return "redirect:/home";
    }
//











    @GetMapping("/home")
    public String mySuccess(Model model) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();

        User posts=userRepo.findByEmail(name);


////        model.addAttribute("myid",posts.getId());
//        LOGGER.info("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
//        LOGGER.info("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        LOGGER.info("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

        Long x= posts.getId();

        List<Text> correct=new ArrayList<>();

        List<Text> textzz = textRepo.findAll();
        for (Text b: textzz) {
                if (b.getUser().getId().equals(x)){
                    correct.add(b);
                }




        }
        model.addAttribute("textzz",correct);
//        model.addAttribute("x",x);
        LOGGER.info("zfzedq"+model.toString());
//        LOGGER.info("xxxx"+x);
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
