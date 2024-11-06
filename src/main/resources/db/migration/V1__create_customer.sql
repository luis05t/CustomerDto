-- Employees Table
CREATE TABLE employees (
                           employee_id SERIAL PRIMARY KEY,
                           first_name VARCHAR(100) NOT NULL,
                           last_name VARCHAR(100) NOT NULL,
                           position VARCHAR(100) NOT NULL,
                           department VARCHAR(100) NOT NULL,
                           salary DECIMAL(10, 2) NOT NULL,
                           hiring_date DATE NOT NULL
);

-- Attendance Table
CREATE TABLE attendances (
                             id SERIAL PRIMARY KEY,
                             employee_id INTEGER NOT NULL,
                             date DATE NOT NULL,
                             check_in TIME NOT NULL,
                             check_out TIME NOT NULL,
                             status VARCHAR(20) NOT NULL,
                             attendance_type VARCHAR(20) NOT NULL,  -- Type of attendance (e.g. Regular, Late, Absent)
                             FOREIGN KEY (employee_id) REFERENCES employees(employee_id) ON DELETE CASCADE,
                             CHECK (check_out > check_in)  -- Ensures check_out is later than check_in
);
