DROP TABLE IF EXISTS customer;
DROP TABLE IF EXISTS comment;
DROP TABLE IF EXISTS restaurant;

CREATE TABLE IF NOT EXISTS customer(
                                       id bigint NOT NULL,
                                       name varchar(50),
                                       surname varchar(50),
                                       longitude double precision,
                                       latitude double precision,
                                       CONSTRAINT customer_pkey PRIMARY KEY (id)
);

CREATE SEQUENCE IF NOT EXISTS CUSTOMER_ID_SEQ start with 1 increment by 50;


CREATE TABLE IF NOT EXISTS comment(
                                      id bigint NOT NULL,
                                      score double precision,
                                      text varchar(250),
                                      customer_id bigint,
                                      restaurant_id varchar(255),
                                      CONSTRAINT comment_pkey PRIMARY KEY(id)
);
CREATE SEQUENCE IF NOT EXISTS COMMENT_ID_SEQ start with 1 increment by 50;

CREATE TABLE IF NOT EXISTS restaurant(
                                       id varchar(255) NOT NULL,
                                       name varchar(50),
                                       longitude double precision,
                                       latitude double precision,
                                       averageScore double precision,
                                       CONSTRAINT restaurant PRIMARY KEY (id)
);

CREATE SEQUENCE IF NOT EXISTS RESTAURANT_ID_SEQ;

