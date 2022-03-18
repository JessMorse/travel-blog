package com.jessmorse.travelblog.comment;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public void addComment (@RequestBody Comment comment){
        commentService.addComment(comment);
    };

    @DeleteMapping("{id}")
    public void deleteComment (@PathVariable("id") long commentId){
        commentService.deleteComment(commentId);
    };

    @PutMapping("{id}")
    public void updateComment (@PathVariable("id") long commentId, Comment comment){
        commentService.updateComment(commentId, comment);
    };

    @GetMapping("post/{id}")
    public List<Comment> getCommentsByPost (@PathVariable("id")long postId){
        return commentService.getCommentsByPost(postId);
    };

    @GetMapping("user/{id}")
    public List<Comment> getCommentsByUser (@PathVariable("id")long userId) {
        return commentService.getCommentsByUser(userId);
    };
}
