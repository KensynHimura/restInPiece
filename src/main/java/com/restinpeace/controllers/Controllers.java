package com.restinpeace.controllers;

import com.restinpeace.entities.Role;
import com.restinpeace.entities.User;
import com.restinpeace.service.RoleServiceImpl;
import com.restinpeace.service.UserServiceImpl;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Set;

@Controller
public class Controllers {

    private final UserServiceImpl userService;

    private final RoleServiceImpl roleService;

    public Controllers(UserServiceImpl userService, RoleServiceImpl roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/admin")
    public String restAdmin(Model model) {
        User user = (User) userService.loadUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName()) ;
        Set<Role> roles = roleService.allRoles();
        model.addAttribute("user", user);
        model.addAttribute("roles", roles);
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
