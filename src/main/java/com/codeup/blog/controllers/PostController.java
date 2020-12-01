package com.codeup.blog.controllers;

import com.codeup.blog.models.Post;
import com.codeup.blog.repos.PostRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    private final PostRepository postDao;

    public PostController(PostRepository postDao){
        this.postDao = postDao;
    }

    @GetMapping("/posts")
    public String allPosts(Model model){
/*  Before dependency injection via PostRepository
        List<Post> postList = new ArrayList<>();
        postList.add(new Post(0, "A Post", "This is a Post"));
        postList.add(new Post(0, "Another Post", "This is another Post"));
        model.addAttribute("posts", postList);
*/
        List<Post> posts = postDao.findAll();
        model.addAttribute("posts", posts);
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String viewSelectedPost(@PathVariable long id, Model model){
/*  Before dependency injection
        Post post = new Post(0, "Sample Post", "This would be the body for the selected post");
        model.addAttribute("post", post);
*/
        Post selectedPost = postDao.getOne(id);
        model.addAttribute("selectedPost", selectedPost );
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String createNewPost(Model model){
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String savingNewPost(@ModelAttribute Post post){
        postDao.save(post);
        return "redirect:/posts/" + post.getId();
    }

    @GetMapping("/post/delete/{id}")
    public String deletePost(@PathVariable long id){
        Post post = postDao.getOne(id);
        postDao.delete(post);
        return "redirect:/posts";
    }

    @GetMapping("/posts/edit/{id}")
    public String editAd(@PathVariable long id, Model model) {
        Post post = postDao.getOne(id);
        model.addAttribute("post", post);
        return "posts/create";
    }

    @PostMapping("/posts/edit")
    public String updateAd(@ModelAttribute Post post) {
        postDao.save(post);
        return "redirect:/posts/" + post.getId();
    }
}
