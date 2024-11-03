package com.regis.Registraion_Form.controller;


import com.regis.Registraion_Form.config.CustomUserService;
import com.regis.Registraion_Form.entity.User;
import com.regis.Registraion_Form.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/user")
public class HomeController {

    @Autowired
    public UserRepository repo;
    @Autowired
    public CustomUserService customUserService;

    @GetMapping("/home")
    public String home(Principal p, Model m) {

        String em = p.getName();
        User u = repo.findByEmail(em);

            m.addAttribute("fullname", u.getFullname());
            m.addAttribute("em", u.getEmail());

        List<User> users = customUserService.getAllUsers();
        m.addAttribute("users", users);
        return "home";

    }
}

