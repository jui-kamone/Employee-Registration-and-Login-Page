package com.regis.Registraion_Form.controller;

import com.regis.Registraion_Form.entity.User;
import com.regis.Registraion_Form.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class UserController {


    @Autowired
    private UserRepository repo;

    @Autowired
  private BCryptPasswordEncoder bp;

    @GetMapping("/")
    public String home(){
        return "index";
    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }


    @PostMapping("/register")
    public String register(@ModelAttribute User u,  RedirectAttributes redirectAttributes){
        System.out.println(u);
        u.setPassword(bp.encode(u.getPassword()));
        u.setRole("Role_User");
   repo.save(u);
        redirectAttributes.addFlashAttribute("successMessage", "User registered successfully!");

//   return "redirect:/";
        return "redirect:/login";
    }


}
