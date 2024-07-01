-- I think we could remove the departments to offices relationship and just have the department and office attached to employee
-- intuitively, we could have people from various departments in different locations, 
-- so we don't really need to tie down any given department to a particular office

select * from jobs;

INSERT INTO departments(department_name, description)
VALUES
  ('test_dept_1', 'test1')
, ('test_dept_2', 'test2')
;

 INSERT INTO offices (
	  office_name
    , office_street_address
    , office_address_suite
    , office_location_city
    , office_location_province
    , office_zip_code
    , office_location_country
    , max_capacity
)
 VALUES
   (
		 'Columbus Office'
	   , '101 Office Ave'
	   , 'STE 200'
	   , 'Columbus'
	   , 'OH'
       , 12345
	   , 'USA'
	   , 205
	)
 , (
		 'Cincinnati Office'
	   , '404 Strange Lane'
	   , ''
	   , 'Cincinnati'
	   , 'OH'
       , 45678
	   , 'USA'
	   , 80
	)
 ;
 
 select * from offices;
 
 INSERT INTO jobs(job_name, job_description)
 VALUES
   ('Bean Counter', 'Count the beans and write bean reports to give us our bean metrics')
 , ('Bean Farmer', 'Farm the beans so we can count them and then sell them so we can then count the bean sales')
 , ('Bean Manager', 'Manage the bean farmers and bean sellers to keep them in line and ensure the bean counters can give us the good bean numbers')
 , ('Bean Seller', 'Drive sales of our beans to our bean clients')
 , ('Bean Executive', 'Report the bean figures to the bean shareholders after our bean reports have been put together')
 ;
 
 INSERT INTO employees (first_name, last_name, hourly_pay, hire_date, job_id, department_id, office_id)
 VALUES
   ('Jon', 'Provan', 35.00, '1985/01/01', 2, 1, 2)
 , ('Sara', 'Smith', 21.67, '2001/07/05', 1, 2, 2)
 , ('Alexander', 'Hamilton', 65.23, '2015/10/15', 3, 1, 2)
 ;
 
 select * from employees;