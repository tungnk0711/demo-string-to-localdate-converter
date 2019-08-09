package com.codegym.controller;

import com.codegym.model.Employee;
import com.codegym.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @GetMapping("/register")
    public ModelAndView registerForm() {
        ModelAndView modelAndView = new ModelAndView("/user/register");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @PostMapping(value = "/register")
    public String registerAccount(@ModelAttribute User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errorMessage", bindingResult.getAllErrors());
            return "/user/register";
        }

        // register user here...

        model.addAttribute("user", user);
        return "/user/detail";
    }
}
