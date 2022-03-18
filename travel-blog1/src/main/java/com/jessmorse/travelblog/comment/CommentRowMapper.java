package com.jessmorse.travelblog.comment;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class CommentRowMapper implements RowMapper<Comment> {

    @Override
    public Comment mapRow(ResultSet rs, int rowNum) throws SQLException {
        Comment comment = new Comment (
            rs.getInt("comment_id"),
            rs.getInt("user_id"),
            rs.getInt("post_id"),
            rs.getString("post_comment")
        );
        return comment;
    }
}
