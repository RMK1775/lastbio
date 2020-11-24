package com.codeup.blog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {

    @GetMapping("/add/3/and/4")
    @ResponseBody
    public int addition() {
        return 7;
    }

    @GetMapping("/subtract/3/from/10")
    @ResponseBody
    public int subtraction() {
        return 7;
    }

    @GetMapping("/multiply/4/and/5")
    @ResponseBody
    public int multiplication() {
        return 20;
    }

    @GetMapping("/divide/6/and/3")
    @ResponseBody
    public int division() {
        return 2;
    }
}
