INSERT INTO users( user_id, user_name, email, user_password)
    VALUES (1,'JESS', 'JESS@EMAIL','PASSWORD');

INSERT INTO blogposts(
    post_id, user_id, post_body, country, rating, top_tip, trip_cost)
    VALUES(
    1, 1, 'GREAT', 'FRANCE', 5, 'VISIT THE EIFFEL TOWER', 200
    );
