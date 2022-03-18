CREATE TABLE comments(
    comment_id BIGSERIAL PRIMARY KEY,
    user_id BIGSERIAL,
    post_id BIGSERIAL,
    post_comment VARCHAR(255),
    FOREIGN KEY (user_id) REFERENCES users(user_id),
    FOREIGN KEY (post_id) REFERENCES blogposts(post_id)
);