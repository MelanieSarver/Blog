package com.codeup.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Created by mel on 2/7/17.
 */
@Controller
public class PostController {
    @GetMapping("/posts")
    @ResponseBody
    public String index() {
        return "<h1>Posts index page</h1>";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String post(@PathVariable int id) {
       return  "<h1>View an individual post<h1>";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String create() {
        return "<h1>View the form for creating a post<h1>";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String view() {
        return "<h1>Create a new Post";
    }
}
