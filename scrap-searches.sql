# scrap searches

SELECT * FROM departments;

select * from employees;


select * from offices;


SELECT * from employees;

SELECT * FROM employees WHERE first_name LIKE 'jon';

SELECT COUNT(*)
FROM employees;

SELECT COUNT(*)
FROM employees AS e
JOIN offices AS o ON o.office_id = e.office_id
WHERE e.office_id = 3;

