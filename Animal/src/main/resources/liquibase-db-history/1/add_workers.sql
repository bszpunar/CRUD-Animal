--liquibase formatted sql
--changeset zoo:1

create table worker(
    id INT AUTO_INCREMENT PRIMARY KEY,
    w_name VARCHAR(150),
    age INT,
    pupil_id INT
);

ALTER TABLE worker ADD FOREIGN KEY (pupil_id) REFERENCES animal(id);