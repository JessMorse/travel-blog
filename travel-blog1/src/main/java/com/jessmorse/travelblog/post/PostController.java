package com.jessmorse.travelblog.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/post")
public class PostController {

    private PostService postService;

   // @Autowired
    public PostController(PostService postService) {this.postService = postService;};

    @PostMapping
    public void addNewPost(@RequestBody Post post) {
        postService.addNewPost(post);
    }

    @DeleteMapping("{id}")
    public void deletePost(@PathVariable("id")long postId){
        postService.deletePost(postId);
    };

    @GetMapping("{id}")
    public Optional<Post> getPostById( @PathVariable("id")long postId) {
        return postService.getPostById(postId);};


    @PutMapping("{id}")
    public void updatePost(@PathVariable("id") long postId, @RequestBody Post post){
        postService.updatePost(postId, post);};

    @GetMapping
    public List<Post> getAllPosts() {return postService.getAllPosts();};

    //@GetMapping
    //public int getCountryAverageRating(String country) {return postService.getCountryAverageRating(country);};

    @GetMapping("/country/{id}")
    public List<Post> getPostsByCountry(@PathVariable("id") String country) {
        return postService.getPostsByCountry(country);
    };

    @GetMapping("/user/{id}")
    List<Post> getPostsByUser(@PathVariable("id") long userId) {
        return postService.getPostsByUser(userId);
    };
}
