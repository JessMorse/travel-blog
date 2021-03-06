package com.jessmorse.travelblog.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private PostDAO postDAO;

    //@Autowired
    public PostService(@Qualifier("Post") PostDAO postDAO){
        this.postDAO = postDAO;
    }

    public void addNewPost(Post post) {postDAO.addNewPost(post);};

    public void deletePost(long postId) {postDAO.deletePost(postId);};

    public Optional<Post> getPostById(long postId) { return postDAO.getPostById(postId);};

    public void updatePost(long postId, Post post) {postDAO.updatePost(postId, post);};

    public List<Post> getAllPosts() {return postDAO.getAllPosts();};

    public double getCountryAverageRating(String country) {return postDAO.getCountryAverageRating(country);};

    public List<Post> getPostsByCountry(String country) {return postDAO.getPostsByCountry(country);};

    public List<Post> getPostsByUser(long userId) {return postDAO.getPostsByUser(userId);};

}
