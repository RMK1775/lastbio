package com.codeup.blog.controllers;

import com.codeup.blog.models.Post;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    @GetMapping("/posts")
    public String allPosts(Model model){
        List<Post> postList = new ArrayList<>();
        postList.add(new Post(0, "A Post", "This is a Post"));
        postList.add(new Post(0, "Another Post", "This is another Post"));
        model.addAttribute("posts", postList);
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String viewSelectedPost(@PathVariable long id, Model model){
        Post post = new Post(0, "Sample Post", "This would be the body for the selected post");
        model.addAttribute("post", post);
        return "posts/show";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String createNewPost(){
        return "post create form";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String savingNewPost(){
        return "new post sent to database";
    }
}
