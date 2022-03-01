package com.jessmorse.travelblog.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;
import java.util.Optional;

public class PostService {

    private final PostDAO postDAO;

    @Autowired
    public PostService(@Qualifier("Post") PostDAO postDAO){
        this.postDAO = postDAO;
    }

    public void addNewPost(Post post) {postDAO.addNewPost(post);};

    public void deletePost(long postId) {postDAO.deletePost(postId);};

    public Optional<Post> getPostById(long postId) { return postDAO.getPostById(postId);};

    public void updatePost(Post post) {postDAO.updatePost(post);};

    public List<Post> getAllPosts() {return postDAO.getAllPosts();};



}