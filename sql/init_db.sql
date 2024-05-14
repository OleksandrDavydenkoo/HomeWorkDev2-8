CREATE TABLE IF NOT EXISTS worker
(
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(1000) NOT NULL CHECK (LENGTH(name) >= 2 AND length(name) <= 1000),
    birthday DATE CHECK(birthday > '1900.01.01'),
    level VARCHAR(1000) NOT NULL CHECK (level IN('Trainee', 'Junior', 'Middle', 'Senior')),
    salary INT CHECK (salary >= 100 AND salary <= 100000)
    );

CREATE TABLE IF NOT EXISTS client
(
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(1000) NOT NULL CHECK (length(name) >= 2 AND length(name) <= 1000)
    );

CREATE TABLE IF NOT EXISTS project
(
    id BIGSERIAL PRIMARY KEY,
    client_id BIGINT REFERENCES client(id),
    start_data DATE,
    finish_data DATE
    );

CREATE TABLE IF NOT EXISTS project_worker
(
    project_id BIGINT NOT NULL REFERENCES project(id),
    worker_id BIGINT NOT NULL REFERENCES worker(id),
    PRIMARY KEY (project_id, worker_id)
    );