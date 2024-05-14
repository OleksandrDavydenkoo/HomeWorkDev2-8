SELECT id AS project_name, EXTRACT(year FROM AGE(finish_data, start_data)) * 12 +
                           EXTRACT(month FROM AGE(finish_data, start_data)) AS month_count FROM project;