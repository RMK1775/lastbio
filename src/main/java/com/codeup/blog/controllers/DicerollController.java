package com.codeup.blog.controllers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class DicerollController {

    @GetMapping("/roll-dice")
    public String promptGuess() {
        return ("/roll-dice");
    }

    @GetMapping("/roll-dice/{guess}")
    public String returnResult(@PathVariable String guess, Model model) {
        int userNum = Integer.parseInt(guess);
        int rolledNum = (int) ((Math.random() * 6) + 1);
        String message = "Your guess was " + userNum + " and the number rolled was " + rolledNum + ".";
        if (userNum == rolledNum) {
            message += " Huzzah!";
        } else {
            message += " Bummer... try again?";
        }
        model.addAttribute("message", message);
        return "/roll-dice";
    }
}
