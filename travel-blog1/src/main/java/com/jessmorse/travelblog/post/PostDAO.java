package com.jessmorse.travelblog.post;

import java.util.List;
import java.util.Optional;

public interface PostDAO {
    void addNewPost( Post post);
    void deletePost(long postId);
    Optional<Post> getPostById(long postId);
    void updatePost(Post post);
    List<Post> getAllPosts();
};