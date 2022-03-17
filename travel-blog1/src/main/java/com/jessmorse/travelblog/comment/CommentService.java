package com.jessmorse.travelblog.comment;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    private CommentDAO commentDAO;

    public CommentService(@Qualifier("comment") CommentDAO commentDAO) {
        this.commentDAO = commentDAO;}

    public void addComment (Comment comment){
        commentDAO.addComment(comment);
    };

    public void deleteComment (long commentId){
        commentDAO.deleteComment(commentId);
    };

    public void updateComment (long commentId, Comment comment){
        commentDAO.updateComment(commentId, comment);
    };

    public List<Comment> getCommentsByPost (long postId) {
        return commentDAO.getCommentsByPost(postId);
    };

    public List<Comment> getCommentsByUser (long userId){
        return commentDAO.getCommentsByUser(userId);
    };
}
