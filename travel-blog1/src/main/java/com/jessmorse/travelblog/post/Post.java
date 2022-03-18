package com.jessmorse.travelblog.post;

import java.time.LocalDate;

public class Post {
    private long postId;
    private long userId;
    private String postBody;
    private String Country;
    private int rating;
    private String topTip;
    private int cost;
    private LocalDate datePosted;
    private String userName;

    public Post(long postId, long userId, String postBody, String country, int rating, String topTip, int cost, LocalDate datePosted, String userName) {
        this.postId = postId;
        this.userId = userId;
        this.postBody = postBody;
        Country = country;
        this.rating = rating;
        this.topTip = topTip;
        this.cost = cost;
        this.datePosted = datePosted;
        this.userName = userName;
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

    public String getPostBody() {
        return postBody;
    }

    public void setPostBody(String postBody) {
        this.postBody = postBody;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getTopTip() {
        return topTip;
    }

    public void setTopTip(String topTip) {
        this.topTip = topTip;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public LocalDate getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(LocalDate datePosted) {
        this.datePosted = datePosted;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", userId=" + userId +
                ", postBody='" + postBody + '\'' +
                ", Country='" + Country + '\'' +
                ", rating=" + rating +
                ", topTip='" + topTip + '\'' +
                ", cost=" + cost +
                ", datePosted=" + datePosted +
                ", userName='" + userName + '\'' +
                '}';
    }
}
