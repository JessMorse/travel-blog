package com.jessmorse.travelblog.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/post")
public class PostController {

    private PostService postService;

    @Autowired
    public PostController(PostService postService) {this.postService = postService;};

    @PostMapping
    public void addNewPost(@RequestBody Post post) {
        postService.addNewPost(post);
    }

    @DeleteMapping("{id}")
    public void deletePost(@PathVariable("id")long postId){};

    @GetMapping("{id}")
    public Optional<Post> getPostById( @PathVariable("id")long postId) {
        return postService.getPostById(postId);};


    @PutMapping("{id}")
    public void updatePost(Post post){postService.updatePost(post);};

    @GetMapping
    public List<Post> getAllPosts() {return postService.getAllPosts();};

//    @GetMapping
//    public int getCountryAverageRating() {return postService.getCountryAverageRating();};


}
