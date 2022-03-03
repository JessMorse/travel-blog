package com.jessmorse.travelblog.post;

import com.jessmorse.travelblog.user.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static java.time.LocalDate.now;

@Qualifier("Post")
@Repository
public class PostDataAccessService implements PostDAO {

    @Autowired
    PostRowMapper autowiredRowMapper;

    private JdbcTemplate jdbcTemplate;

    public PostDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void addNewPost(Post post) {
        String sql = """
                INSERT INTO blogposts(
                                      post_id, user_id, post_body, country, rating, top_tip, trip_cost, date_posted)
                                      VALUES(?,?,?,?,?,?,?,?);""";
        jdbcTemplate.update(sql,post.getPostId(),post.getUserId(), post.getPostBody(),post.getCountry(), post.getRating(), post.getTopTip(),post.getCost(), now());

    }

    @Override
    public void deletePost(long postId) {
        String sql = """
                DELETE FROM blogposts WHERE post_id = ?;""";
        jdbcTemplate.update(sql,postId);
    }

    @Override
    public Optional<Post> getPostById(long postId) {
        String sql = """
                SELECT * FROM blogposts WHERE postId = ? ;""";
        return jdbcTemplate.query(sql, autowiredRowMapper, postId).stream().findAny();
    }

    @Override
    public void updatePost(Post post) {
        String sql = """
                UPDATE blogposts SET
                post_body = ?, country = ?, rating = ?, top_tip = ?, trip_cost = ?)
                WHERE user_id = ?;""";
        jdbcTemplate.update(sql, post.getPostBody(), post.getCountry(), post.getRating(), post.getTopTip(), post.getCost(), post.getPostId());
    }

    @Override
    public List<Post> getAllPosts() {
        String sql = """
                SELECT * FROM blogposts ORDER BY date_posted DESC;""";
        return jdbcTemplate.query(sql, autowiredRowMapper);
    }

/*
    @Override
    public int getCountryAverageRating(String country) {
        String sql = """
                SELECT AVG(rating) FROM blogposts WHERE country = ?;""";
        return jdbcTemplate.query(sql, country);
    }
*/
}
