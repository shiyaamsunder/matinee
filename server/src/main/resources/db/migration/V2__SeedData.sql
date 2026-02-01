INSERT INTO MT_USER ( username, pw_hash, role, created_date, modified_date )
VALUES
    ('admin', 'admin', 'admin', current_timestamp, current_timestamp),
    ('shiyaam', 'shiyaam', 'user', current_timestamp, current_timestamp),
    ('gandalf', 'gandlaf', 'user', current_timestamp, current_timestamp);



INSERT INTO MOVIE ( title, image, description, rating, genre, release_date, created_date, modified_date )
VALUES
    ('28 Years Later: The Bone Temple',
    'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR49pcW8b3Jz6BGY8arAPsiPtfy72FyR2mJo_GaqnU4DvZOcq49Qy-qCkATh8kUSnw0d3lhxA&s=10',
    'Dr. Kelson finds himself in a shocking new relationship with consequences that could change the world as he knows it, while Spike''s encounter with Jimmy Crystal becomes a nightmare he can''t escape.',
    7.8,
    'Horror', '16 January 2026', current_timestamp, current_timestamp ),
    ('Marty Supreme',
    'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSI7gWlgckwwtpfWa3pwuugQ4x3ZsZK8CYpjgrCex0b1VcLjP5uzVGEffb5zD_OssaFiWwC0w&s=10',
     'Marty Mauser, a wily hustler with a dream no one respects, goes to hell and back in pursuit of greatness.',
     8.2,
     'Sport/Drama', '23 January 2026', current_timestamp, current_timestamp);


INSERT INTO SCREEN ( screen_name, capacity, audio_type, projection_type, resolution, created_date, modified_date )
VALUES
    ('Screen 1', 40, 'DTS', null, null, current_timestamp, current_timestamp),
    ('Screen 2', 84, 'DTS', null, null, current_timestamp, current_timestamp),
    ('Screen 3', 84, 'DTS', 'LASER', '2K', current_timestamp, current_timestamp),
    ('Screen 4', 150, 'Dolby', 'BARCO', '4K', current_timestamp, current_timestamp);
