package com.jessmorse.travelblog.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
        jdbcTemplate.update(sql,post.getPostId(),post.getUserId(),
                post.getPostBody(),post.getCountry(), post.getRating(),
                post.getTopTip(),post.getCost(), LocalDate.now());

    }

    @Override
    public void deletePost(long postId) {
        String sql = """
                DELETE * FROM blogposts WHERE post_id = ?;""";
        jdbcTemplate.update(sql,postId);
    }

    @Override
    public Optional<Post> getPostById(long postId) {
        String sql = """
                SELECT * FROM blogposts WHERE post_id = ? ;""";
        return jdbcTemplate.query(sql, autowiredRowMapper, postId).stream().findAny();
    }

    @Override
    public void updatePost(long postId, Post post) {
        String sql = """
                UPDATE blogposts SET
                post_body = ?, country = ?, rating = ?, top_tip = ?, trip_cost = ?
                WHERE user_id = ?;""";
        jdbcTemplate.update(sql, post.getPostBody(), post.getCountry(),
                post.getRating(), post.getTopTip(), post.getCost(), postId);
    }

    @Override
    public List<Post> getAllPosts() {
        String sql = """
                SELECT * FROM blogposts ORDER BY date_posted DESC;""";
        return jdbcTemplate.query(sql, autowiredRowMapper);
    }

    @Override
    public List<Post> getPostsByCountry(String country) {
        String sql = """
                SELECT * FROM blogposts WHERE country = ? ORDER BY date_posted DESC;""";
        return jdbcTemplate.query(sql, autowiredRowMapper, country);
    }

    @Override
    public List<Post> getPostsByUser(long userId) {
        String sql = """
                SELECT * FROM blogposts WHERE userId = ? ORDER BY date_posted DESC;""";
        return jdbcTemplate.query(sql, autowiredRowMapper, userId);
    }


//    @Override
//    public int getCountryAverageRating(String country) {
//        String sql = """
//                SELECT AVG(rating) FROM blogposts GROUP BY country WHERE country = ? ;""";
//        return jdbcTemplate.queryForObject(sql, country,Double.class);
//    }

//    public LocalDate getCurrentDate() {
//        LocalDate date = LocalDate.now();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//        LocalDate currentDate = date.format(formatter);
//    }
}
