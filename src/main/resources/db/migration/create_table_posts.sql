---liquibase formatted sql

--changeset user:create_table_posts.sql runInTransaction:true

CREATE TABLE posts (
    id                 BIGSERIAL                  PRIMARY KEY,
    name               VARCHAR                    DEFAULT NULL,
    contents           TEXT                       DEFAULT NULL,
    created_at         TIMESTAMP                  DEFAULT now()
);