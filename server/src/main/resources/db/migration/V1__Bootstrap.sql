-- TODO:
-- 1. Add proper comments
-- 2. add on delete on update for foreign keys
-- 3. evaluate whether a trigger is needed for modified_date

CREATE TABLE MT_USER (
    user_id     UUID  DEFAULT gen_random_uuid() PRIMARY KEY,
    username    VARCHAR(64) NOT NULL,
    pw_hash     VARCHAR(256) NOT NULL,
    role        VARCHAR(64) NOT NULL,
    created_date TIMESTAMP DEFAULT now(),
    modified_date TIMESTAMP DEFAULT now()
);

CREATE UNIQUE INDEX idx_user_username ON MT_USER (username);

CREATE TABLE MOVIE (
    movie_id     UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    title        varchar(128) NOT NULL,
    image        TEXT,
    description  TEXT,
    rating       NUMERIC,
    genre        VARCHAR(64),
    release_date TIMESTAMP,
    created_date TIMESTAMP DEFAULT now(),
    modified_date TIMESTAMP DEFAULT now()
);

CREATE INDEX idx_movie_title ON MOVIE (title);
CREATE INDEX idx_movie_genre ON MOVIE (genre);

CREATE TABLE SCREEN (
    screen_id   UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    screen_name VARCHAR(128) NOT NULL,
    capacity    INTEGER,
    audio_type  VARCHAR(128),
    video_type VARCHAR(128),
    created_date TIMESTAMP DEFAULT now(),
    modified_date TIMESTAMP DEFAULT now()
);

CREATE INDEX idx_screen_screen_name ON SCREEN (screen_name);

CREATE TABLE SHOWTIME(
    showtime_id     UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    screen_id       UUID REFERENCES SCREEN(screen_id) NOT NULL,
    movie_id        UUID REFERENCES MOVIE(movie_id) NOT NULL,
    show_start      TIMESTAMP NOT NULL,
    show_end        TIMESTAMP NOT NULL,
    created_date TIMESTAMP DEFAULT now(),
    modified_date TIMESTAMP DEFAULT now()
);

CREATE INDEX idx_showtime_movie_id ON SHOWTIME (movie_id);

CREATE TABLE RESERVATION (
    reservation_id  UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    user_id         UUID REFERENCES MT_USER(user_id) NOT NULL,
    showtime_id     UUID REFERENCES SHOWTIME(showtime_id) NOT NULL,
    count           INTEGER,
    price           NUMERIC,
    completed       BOOLEAN DEFAULT false NOT NULL,
    cancelled       BOOLEAN DEFAULT false NOT NULL,
    created_date TIMESTAMP DEFAULT now(),
    modified_date TIMESTAMP DEFAULT now()
);

CREATE INDEX idx_reservation_user_id ON RESERVATION(user_id);
