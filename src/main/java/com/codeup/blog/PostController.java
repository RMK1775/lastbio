package com.codeup.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

public class PostController {

    @GetMapping("/posts")
    public String allPosts(){
        return "posts";
    }

    @GetMapping("/posts/{id}")
    public String viewSelectedPost(@PathVariable int id){
        return "a post";
    }

    @GetMapping("/posts/create")
    public String viewCreatePostForm(){
        return "post create form";
    }

    @PostMapping("/posts/create")
    public String createNewPost(){
        return "new post";
    }
}
