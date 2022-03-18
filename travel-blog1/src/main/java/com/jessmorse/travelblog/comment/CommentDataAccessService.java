package com.jessmorse.travelblog.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Qualifier("comment")
@Repository
public class CommentDataAccessService implements CommentDAO {

    @Autowired
    CommentRowMapper autowiredRowMapper;

    private JdbcTemplate jdbcTemplate;

    public CommentDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public void addComment(Comment comment){
        String sql = """
                INSERT INTO comments(user_id, post_id, post_comment)
                VALUES (?, ?, ?);
                """;
        jdbcTemplate.update(sql, comment.getUserId(), comment.getPostId(),
                comment.getComment());
    };

    @Override
    public void deleteComment (long commentId){
        String sql = """
                DELETE from comments WHERE comment_id = ?;""";
        jdbcTemplate.update(sql,commentId);
    };

    @Override
    public void updateComment (long commentId, Comment comment){
        String sql = """
                UPDATE comments SET post_comment = ? WHERE comment_id = ?;""";
        jdbcTemplate.update(sql, comment.getComment(), commentId);
    };

    @Override
    public List<Comment> getCommentsByPost (long postId){
        String sql = """
                SELECT * FROM comments WHERE post_id = ?;""";
        return jdbcTemplate.query(sql, autowiredRowMapper, postId);
    };

    @Override
    public List<Comment> getCommentsByUser (long userId){
        String sql = """
                
                SELECT * FROM comments WHERE user_id = ?;""";
        return jdbcTemplate.query(sql, autowiredRowMapper, userId);
    };
}
