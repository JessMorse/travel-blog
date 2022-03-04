package com.jessmorse.travelblog.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class PostRowMapper implements RowMapper<Post> {

    @Override
    public Post mapRow (ResultSet rs, int rowNum ) throws SQLException {
        Post post = new Post(
                rs.getInt("post_id"),
                rs.getInt("user_id"),
                rs.getString("post_body"),
                rs.getString("country"),
                rs.getInt("rating"),
                rs.getString("top_tip"),
                rs.getInt("trip_cost"),
                rs.getDate("date_posted").toLocalDate()
        );
        return post;
    }

}
