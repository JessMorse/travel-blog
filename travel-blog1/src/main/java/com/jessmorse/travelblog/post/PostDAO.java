package com.jessmorse.travelblog.post;

import java.util.List;
import java.util.Optional;

public interface PostDAO {
    void addNewPost( Post post);
    void deletePost(long postId);
    Optional<Post> getPostById(long postId);
    void updatePost(long postId, Post post);
    List<Post> getAllPosts();
    double getCountryAverageRating(String country);
    List<Post> getPostsByCountry(String country);
    List<Post> getPostsByUser(long userId);
};