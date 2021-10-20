package com.user.controller;

import com.user.model.User;
import com.user.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping
    public String showList(Model model) {
        Iterable<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "user/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "user/create";
    }

    @PostMapping("/create")
    public String createUser(@Validated @ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user/create";
        }
        userService.save(user);
        return "redirect:/user";
    }
}
