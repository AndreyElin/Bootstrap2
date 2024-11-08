package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.models.User;
import web.services.UserService;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String printUser(Principal principal, Model model) {
        User user = userService.getUserByEmail(principal.getName());
        model.addAttribute("user", user);
        model.addAttribute("role", user.getRoleSet());
        return "user/user";
    }

}
