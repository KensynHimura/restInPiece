package com.restinpeace.controllers;

import com.restinpeace.entities.User;
import com.restinpeace.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controllers {

    private final UserService userService;

    public Controllers(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/admin")
    public String restAdmin(Model model) {
        User user = (User) userService.loadUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName()) ;
        model.addAttribute("user", user);
        return "rest/admin/restAdmin";
    }

    @GetMapping("/user")
    public String restUser(Model model) {
        User user = (User) userService.loadUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName()) ;
        model.addAttribute("user", user);
        return "rest/user/restUser";
    }

    @GetMapping(value = "/denied")
    public String dangerUser() {
        return "/rest/user/denied";
    }
}
