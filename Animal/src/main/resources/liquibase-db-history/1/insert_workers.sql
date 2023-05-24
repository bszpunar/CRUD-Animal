--liquibase formatted sql
--changeset zoo:2

INSERT into worker(id,w_name,age, pupil_id) values (1,"Otis", 29, 1);
INSERT into worker(id,w_name,age, pupil_id) values (2,"Samara", 30, 3);