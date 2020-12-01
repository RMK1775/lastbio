package com.codeup.blog.controllers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ThreadLocalRandom;

@Controller
public class DicerollController {

    @GetMapping("/roll-dice")
    public String promptGuess() {
        return ("/roll-dice");
    }

    @GetMapping("/roll-dice/{guess}")
//    Walkthrough solution
    public String rollDice(@PathVariable int guess, Model model) {
        //Find a random number between 1 and 6.
        int randomNum = ThreadLocalRandom.current().nextInt(1, 6 + 1);
        //Compare the guess to the random number.
        //Store if the number was guessed correctly in a model attribute.
        model.addAttribute("randomNumber", randomNum);
        model.addAttribute("myGuess", guess);
        model.addAttribute("isCorrectGuess", guess == randomNum);

        return "/roll-dice";
    }
/*Needs to be reworked along with corresponding HTML
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
*/
}
