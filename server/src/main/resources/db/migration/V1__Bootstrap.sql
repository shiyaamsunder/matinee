CREATE TABLE MT_USER (
    user_id     UUID  DEFAULT gen_random_uuid() PRIMARY KEY,
    username    VARCHAR(64) NOT NULL,
    pw_hash     VARCHAR(256) NOT NULL,
    role        VARCHAR(64) NOT NULL,
    created_date TIMESTAMP NOT NULL,
    modified_date TIMESTAMP NOT NULL
);

CREATE UNIQUE INDEX idx_user_username ON MT_USER (username);

COMMENT ON TABLE MT_USER IS 'Matinee_User: Primary Table for storing user details.';
COMMENT ON COLUMN MT_USER.role IS 'Matinee User Role: admin|user';

CREATE TABLE MOVIE (
    movie_id     UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    title        varchar(128) NOT NULL,
    image        TEXT,
    description  TEXT,
    rating       NUMERIC,
    genre        VARCHAR(64),
    release_date TIMESTAMP,
    created_date TIMESTAMP NOT NULL,
    modified_date TIMESTAMP NOT NULL
);

COMMENT ON TABLE MOVIE IS 'Contains details about the movie.';
COMMENT ON COLUMN MOVIE.title IS 'Matinee User Role: admin|user';

CREATE INDEX idx_movie_title ON MOVIE (title);
CREATE INDEX idx_movie_genre ON MOVIE (genre);

CREATE TABLE SCREEN (
    screen_id   UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    screen_name VARCHAR(128) NOT NULL,
    capacity    INTEGER,
    audio_type  VARCHAR(128),
    projection_type VARCHAR(128),
    resolution VARCHAR(128),
    created_date TIMESTAMP NOT NULL,
    modified_date TIMESTAMP NOT NULL
);

CREATE INDEX idx_screen_screen_name ON SCREEN (screen_name);

COMMENT ON COLUMN SCREEN.screen_name IS 'Must have a screen name, if no name use something like "Screen 1"';
COMMENT ON COLUMN SCREEN.audio_type IS 'Audio System types like "DTS", "Dolby Surrond" etc.,';
COMMENT ON COLUMN SCREEN.projection_type IS 'Projection System like "BARCO", "IMAX" etc.,';
COMMENT ON COLUMN SCREEN.resolution IS 'Screen Resoultion either xK format (2K, 4K)';

CREATE TABLE SHOWTIME(
    showtime_id     UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    screen_id       UUID REFERENCES SCREEN(screen_id) ON DELETE CASCADE NOT NULL,
    movie_id        UUID REFERENCES MOVIE(movie_id) ON DELETE CASCADE NOT NULL,
    show_start      TIMESTAMP NOT NULL,
    show_end        TIMESTAMP NOT NULL,
    created_date TIMESTAMP NOT NULL,
    modified_date TIMESTAMP NOT NULL
);

COMMENT ON TABLE SHOWTIME IS 'Table which links a screen with a movie for specified showtime';
COMMENT ON COLUMN SHOWTIME.show_start IS 'UTC Timestamp without timezone';
COMMENT ON COLUMN SHOWTIME.show_end IS 'UTC Timestamp without timezone';

CREATE INDEX idx_showtime_movie_id ON SHOWTIME (movie_id);

CREATE TABLE RESERVATION (
    reservation_id  UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    user_id         UUID REFERENCES MT_USER(user_id) NOT NULL,
    showtime_id     UUID REFERENCES SHOWTIME(showtime_id) ON DELETE CASCADE NOT NULL ,
    count           INTEGER,
    price           NUMERIC,
    completed       BOOLEAN DEFAULT false NOT NULL,
    cancelled       BOOLEAN DEFAULT false NOT NULL,
    created_date TIMESTAMP NOT NULL,
    modified_date TIMESTAMP NOT NULL
);

COMMENT ON TABLE RESERVATION IS 'This table represents a reservation made against a movie in a specified screen and showtime';

CREATE INDEX idx_reservation_user_id ON RESERVATION(user_id);
