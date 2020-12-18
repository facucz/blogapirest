package com.informatorio.blogapirest.controller;

import com.informatorio.blogapirest.model.Post;
import com.informatorio.blogapirest.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/v1")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping(path = "posts")
    public List<Post> getAllPosts() {
        return postService.getAllPost();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "posts")
    public void addPost(@RequestBody Post post) {
        postService.addPost(post);
    }

    @PutMapping(path = "posts/{id}")
    public void updateUser(@RequestBody Post post, @PathVariable long id) {
        postService.updatePost(id, post);
    }

    @DeleteMapping(path = "posts/{id}")
    public String deletePost(@PathVariable long id) {
        postService.deletePost(id);
        return "Post with id " + id + " was successfully delete.";
    }

    @GetMapping(path = "posts/{isPublicado}")
    public List<Post> getAllPosts(@PathVariable boolean isPublicado) {
        return postService.getAllPost(isPublicado);
    }

    @GetMapping(path = "post/{wordInTitle}")
    public List<Post> getAllPosts(@PathVariable String wordInTitle) {
        return postService.getAllPost(wordInTitle);
    }
}
