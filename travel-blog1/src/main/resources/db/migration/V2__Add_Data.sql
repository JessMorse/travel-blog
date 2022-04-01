INSERT INTO users( user_id, user_name, email, user_password)
    VALUES (DEFAULT,'JESS', 'JESS@EMAIL','PASSWORD');
INSERT INTO users( user_id, user_name, email, user_password)
    VALUES (DEFAULT,'BIANCA', 'bianca@gmail.com','password');

INSERT INTO blogposts(
    post_id, user_id, post_body, country, rating, top_tip, trip_cost, date_posted)
    VALUES(
    1, 1, 'GREAT', 'FRANCE', 5, 'VISIT THE EIFFEL TOWER', 200, '2022-01-13'
    );
