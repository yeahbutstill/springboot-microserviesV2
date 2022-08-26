CREATE TABLE course (
    id BIGINT NOT NULL,
    name VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO course (id, name, author) VALUES (1, 'Learn AWS', 'Dani');
INSERT INTO course (id, name, author) VALUES (2, 'Learn Docker', 'Dani');
INSERT INTO course (id, name, author) VALUES (3, 'Learn Kubernetes', 'Dani');