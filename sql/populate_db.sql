INSERT INTO worker (name, birthday, level, salary) VALUES
    ('John Doe', '1990-05-15', 'Trainee', 800),
    ('Jane Smith', '1985-08-22', 'Junior', 1200),
    ('Michael Johnson', '1980-03-10', 'Middle', 2500),
    ('Emily Brown', '1976-11-30', 'Senior', 4500),
    ('David Wilson', '1995-02-18', 'Trainee', 900),
    ('Jessica Lee', '1988-07-05', 'Junior', 1400),
    ('Christopher Taylor', '1972-09-25', 'Middle', 2800),
    ('Amanda Martinez', '1983-04-12', 'Senior', 5000),
    ('Matthew Anderson', '1992-01-08', 'Trainee', 850),
    ('Olivia Garcia', '1987-06-20', 'Junior', 1300);

INSERT INTO client (name) VALUES
    ('ABC Corporation'),
    ('XYZ Corp'),
    ('Acme Ltd'),
    ('Smith Enterprises'),
    ('Jones Co.');

INSERT INTO project (client_id, start_data, finish_data) VALUES
    (1, '2023-01-01', '2023-05-01'),
    (2, '2023-02-15', '2023-09-15'),
    (3, '2023-03-10', '2023-06-30'),
    (4, '2023-04-20', '2023-11-20'),
    (5, '2023-05-05', '2023-08-15'),
    (1, '2023-06-01', '2023-12-01'),
    (2, '2023-07-15', '2024-01-15'),
    (3, '2023-08-10', '2024-03-30'),
    (4, '2023-09-20', '2024-04-20'),
    (5, '2023-10-05', '2024-06-15');

INSERT INTO project_worker (project_id, worker_id) VALUES
    (1, 1),
    (1, 2),
    (1, 3),
    (2, 4),
    (2, 5),
    (3, 6),
    (3, 7),
    (4, 8),
    (4, 9),
    (4, 10),
    (5, 1),
    (5, 2),
    (5, 3),
    (5, 4),
    (6, 5),
    (6, 6),
    (6, 7),
    (7, 8),
    (7, 9),
    (8, 10),
    (9, 1),
    (9, 2),
    (9, 3),
    (10, 4),
    (10, 5),
    (10, 6);