package com.jessmorse.travelblog.comment;

import java.util.List;

public interface CommentDAO {

    void addComment (Comment comment);
    void deleteComment (long commentId);
    void updateComment (long commentId, Comment comment);
    List<Comment> getCommentsByPost (long postId);
    List<Comment> getCommentsByUser (long userId);
}
