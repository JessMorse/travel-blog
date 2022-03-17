package com.jessmorse.travelblog.comment;

public class Comment {

    private long commentId;
    private long postId;
    private long userId;
    private String comment;
    private Boolean liked;

    public Comment(long commentId, long postId, long userId, String comment, Boolean liked) {
        this.commentId = commentId;
        this.postId = postId;
        this.userId = userId;
        this.comment = comment;
        this.liked = liked;
    }

    public Comment(long postId, long userId, String comment, Boolean liked) {
        this.postId = postId;
        this.userId = userId;
        this.comment = comment;
        this.liked = liked;
    }

    public long getCommentId() {
        return commentId;
    }

    public void setCommentId(long commentId) {
        this.commentId = commentId;
    }

    public long getPostId() {
        return postId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Boolean getLiked() {
        return liked;
    }

    public void setLiked(Boolean liked) {
        this.liked = liked;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", postId=" + postId +
                ", userId=" + userId +
                ", comment='" + comment + '\'' +
                ", liked=" + liked +
                '}';
    }
}
