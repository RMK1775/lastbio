package com.codeup.blog.controllers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @GetMapping("/")
    @ResponseBody
    public String sayHello(){
        return "This is the landing page!";
    }

    @GetMapping("/home")
    public String welcome(){
        return "home";
    }

    @GetMapping("hello/{name}")
    public String setHelloMessage(@PathVariable String name, Model model){
        model.addAttribute("name", name);
        return "/hello";
    }

    @GetMapping("/join")
    public String showJoinForm(){
        return "/join";
    }

    @PostMapping("/join")
    public String postJoinForm(@RequestParam(name = "cohort") String cohort, Model model){
        model.addAttribute("cohort", "Welcome to " + cohort + "!");
        return "/join";
    }
}
