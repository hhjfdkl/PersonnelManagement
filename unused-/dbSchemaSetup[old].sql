

DROP TABLE IF EXISTS employees, departments, offices, offices_departments, departments_jobs, jobs CASCADE; 


CREATE TABLE departments (
	  department_id INT NOT NULL AUTO_INCREMENT
    , department_name VARCHAR(256) NOT NULL
    , description VARCHAR(1024)
    
    , CONSTRAINT PRIMARY KEY (department_id)
    , CONSTRAINT UNIQUE UQ_department_name (department_name)
);

CREATE TABLE offices (
	  office_id INT NOT NULL AUTO_INCREMENT
	, office_name VARCHAR(256)
    , office_street_address VARCHAR(512) NOT NULL
    , office_address_suite VARCHAR(32)
    , office_location_city VARCHAR(256) NOT NULL
    , office_location_province VARCHAR(256) NOT NULL
    , office_zip_code INT
    , office_location_country VARCHAR(256)
    , max_capacity INT NOT NULL
    
    , CONSTRAINT PRIMARY KEY (office_id)
    
    
    , CONSTRAINT UNIQUE UQ_office_name (office_name)
);

CREATE TABLE offices_departments (
	  office_id INT
	, department_id INT
    
    , CONSTRAINT PRIMARY KEY (office_id, department_id)
    , CONSTRAINT FOREIGN KEY (office_id) REFERENCES offices (office_id)
    , CONSTRAINT FOREIGN KEY (department_id) REFERENCES departments (department_id)
);

CREATE TABLE jobs (
	  job_id INT NOT NULL AUTO_INCREMENT
    , job_name VARCHAR(256) NOT NULL
    , job_description VARCHAR(4096)
    
    , CONSTRAINT PRIMARY KEY (job_id)
    

    , CONSTRAINT UNIQUE UQ_job_name (job_name)
);

CREATE TABLE departments_jobs (
	  department_id INT
	, job_id INT
    
    , CONSTRAINT PRIMARY KEY (department_id, job_id)
    , CONSTRAINT FOREIGN KEY (department_id) REFERENCES departments (department_id)
    , CONSTRAINT FOREIGN KEY (job_id) REFERENCES jobs (job_id)
);

CREATE TABLE employees (
	  employee_id INT NOT NULL AUTO_INCREMENT
    , first_name VARCHAR(128) NOT NULL
    , last_name VARCHAR(128) NOT NULL
    , hourly_pay DECIMAL(5,2) NOT NULL
    , hire_date DATE NOT NULL
    , job_id INT
    , department_id INT
    , office_id INT
--  , info VARCHAR(4096)	-- could be replaced with an ee info db which contains more detailed info or resume-like info
    
    , CONSTRAINT PRIMARY KEY (employee_id)
    , CONSTRAINT FOREIGN KEY (job_id) REFERENCES jobs (job_id)
    , CONSTRAINT FOREIGN KEY (department_id) REFERENCES departments (department_id)
    , CONSTRAINT FOREIGN KEY (office_id) REFERENCES offices (office_id)
);

-- make employee info table