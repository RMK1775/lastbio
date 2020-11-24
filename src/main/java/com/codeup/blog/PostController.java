package com.codeup.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {

    @GetMapping("/posts")
    @ResponseBody
    public String allPosts(){
        return "posts";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String viewSelectedPost(@PathVariable long id){
        return "a post";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String viewCreatePostForm(){
        return "post create form";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String createNewPost(){
        return "new post";
    }
}
