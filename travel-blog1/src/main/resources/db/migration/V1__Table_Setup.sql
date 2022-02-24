CREATE TABLE users(
    user_id BIGSERIAL PRIMARY KEY,
    user_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    user_password VARCHAR(255) NOT NULL
);

CREATE TABLE blogposts(
    post_id BIGSERIAL PRIMARY KEY,
    user_id BIGSERIAL,
    post_body VARCHAR(255),
    country VARCHAR(255) NOT NULL,
    rating INTEGER,
    top_tip VARCHAR(255),
    trip_cost INTEGER,
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);

