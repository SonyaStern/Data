--liquibase formatted sql
--changeset sofia_krylova@epam.com:1

DROP TABLE IF EXISTS temp_movies;

create table temp_movies
(
    color varchar(255),
    director_name varchar(255),
    num_critic_for_reviews int,
    duration int,
    director_facebook_likes int,
    actor_3_facebook_likes int,
    actor_2_name varchar(255),
    actor_1_facebook_likes int,
    gross int,
    genres varchar(255),
    actor_1_name varchar(255),
    movie_title varchar(255),
    num_voted_users int,
    cast_total_facebook_likes int,
    actor_3_name varchar(255),
    facenumber_in_poster int,
    plot_keywords varchar(255),
    movie_imdb_link varchar(255),
    num_user_for_reviews int,
    language varchar(255),
    country varchar(255),
    content_rating varchar(255),
    budget bigint,
    title_year int,
    actor_2_facebook_likes int,
    imdb_score float,
    aspect_ratio float,
    movie_facebook_likes int
);
--rollback DROP TABLE temp_movies;

--changeset sofia_krylova@epam.com:2

DROP TABLE IF EXISTS movies;

create table movies
(
    genres varchar(255)[],
    main_actor varchar(255),
    movie_title varchar(255),
    imdb_score float
);

--rollback DROP TABLE movies;

--changeset sofia_krylova@epam.com:3

CREATE EXTENSION pg_trgm;

CREATE INDEX movies_trgm_idx ON movies
  USING gin (movie_title gin_trgm_ops);