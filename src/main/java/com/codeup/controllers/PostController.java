package com.codeup.controllers;

import com.codeup.models.Post;
import com.codeup.repositories.Posts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author Created by mel on 2/7/17.
 */
@Controller
public class PostController {
    @Autowired
    Posts postsDao;

    public PostController(Posts postsDao) {
        this.postsDao = postsDao;
    }

    @GetMapping("/posts")
    public String index(Model model) {
        model.addAttribute("posts", postsDao.findAll());
        return "/posts/index";
    }

    @GetMapping("/posts/{id}")
    public String post(@PathVariable int id, Model model) {
        model.addAttribute("post", postsDao.findOne(id));
        return  "/posts/show";
    }

    @GetMapping("/posts/create")
    public String view(Model model) {
        Post post = new Post();
        model.addAttribute("post", post);
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String create(@ModelAttribute Post post, Model model) {
        postsDao.save(post);
        model.addAttribute("post", post);
        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}/edit")
    public String edit(@PathVariable int id, @ModelAttribute Post post, Model model) {
        model.addAttribute("post", postsDao.findOne(id));
        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String update(@ModelAttribute Post post, Model model) {
        postsDao.save(post);
        model.addAttribute("post", post);
        return "redirect:/posts";
    }

    @PostMapping("/posts/delete")
    public String deletePost(@ModelAttribute Post post) {
        postsDao.delete(postsDao.findOne(post.getId()));
        return "redirect:/posts";
    }

}
