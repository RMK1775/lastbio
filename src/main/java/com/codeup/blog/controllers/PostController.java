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
        model.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }

    @GetMapping("posts/search")
    public String searchPosts(@RequestParam(name = "term") String term, Model viewModel){
        term = "%"+term+"%";
        List<Post> dbPosts = postDao.findAllByTitleIsLike(term);
        viewModel.addAttribute("posts", dbPosts);
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String viewSelectedPost(@PathVariable long id, Model model){
/*  Before dependency injection
        Post post = new Post(0, "Sample Post", "This would be the body for the selected post");
        model.addAttribute("post", post);
*/
        model.addAttribute("selectedPost", postDao.getOne(id));
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String createNewPost(Model model){
        return "posts/new";
    }

    @PostMapping("/posts/create")
    public String savingNewPost(@ModelAttribute Post post){
        postDao.save(post);
        return "redirect:/posts/" + post.getId();
    }

    @GetMapping("/posts/delete/{id}")
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
