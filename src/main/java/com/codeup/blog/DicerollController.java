package com.codeup.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class DicerollController {

    @GetMapping("/roll-dice")
    public String promptGuess(){
        return("/roll-dice");
    }

    @GetMapping("/roll-dice/{guess}")
    public String returnResult(@PathVariable String guess, Model model){

        model.addAttribute("guess", guess);
        return guess;
    }
}
