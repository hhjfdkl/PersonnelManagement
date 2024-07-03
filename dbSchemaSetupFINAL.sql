

DROP TABLE IF EXISTS employees, departments, offices CASCADE; 


CREATE TABLE departments (
	  department_id INT NOT NULL AUTO_INCREMENT
    , department_name VARCHAR(256) NOT NULL
    , description VARCHAR(1024)
    
    , CONSTRAINT PRIMARY KEY (department_id)
    , CONSTRAINT UNIQUE UQ_department_name (department_name)
);

CREATE TABLE offices (
	  office_id INT NOT NULL AUTO_INCREMENT
	, office_name VARCHAR(256) NOT NULL
    , street_address VARCHAR(512) NOT NULL
    , address_suite VARCHAR(32)
    , location_city VARCHAR(256) NOT NULL
    , location_state VARCHAR(256) NOT NULL
    , zip_code INT NOT NULL
    , max_capacity INT NOT NULL
    
    , CONSTRAINT PRIMARY KEY (office_id)
    
    , CONSTRAINT UNIQUE UQ_office_name (office_name)
);




CREATE TABLE employees (
	  employee_id INT NOT NULL AUTO_INCREMENT
    , first_name VARCHAR(128) NOT NULL
    , last_name VARCHAR(128) NOT NULL
    , department_id INT
    , office_id INT
    
    , CONSTRAINT PRIMARY KEY (employee_id)
    , CONSTRAINT FOREIGN KEY (department_id) REFERENCES departments (department_id)
    , CONSTRAINT FOREIGN KEY (office_id) REFERENCES offices (office_id)
);

-- make employee info table