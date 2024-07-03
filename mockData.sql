INSERT INTO offices (office_name, street_address, address_suite, location_city, location_state, zip_code, max_capacity)
VALUES
  ('Cincinnati Office', '100 Main St', '', 'Cincinnati', 'OH', 45205, 100) -- 1
, ('Columbus Office', '404 Ferguson Ave', '', 'Columbus', 'OH', 43004, 255) -- 2
, ('Toledo Office', '301 Movers Lane', 'Suite 2', 'Toledo', 'OH', 43606, 26) -- 3 
, ('Cleveland Office', '202 Acceptance Rd', 'Suite 683', 'Cleveland', 'OH', 44112, 48) -- 4
;

;

INSERT INTO departments (department_name, description) 
VALUES
  ('Human Resources', 'Manages employee relations, recruitment, training, and compliance with labor laws.') -- 1
, ('Finance', 'Oversees budgeting, financial reporting, and management of company finances.') -- 2
, ('Marketing', 'Develops marketing strategies, advertising campaigns, and market research.') -- 3
, ('Sales', 'Manages sales activities, customer relationships, and revenue generation.') -- 4
, ('IT', 'Provides technology support, network administration, and IT infrastructure management.') -- 5
, ('Customer Service', 'Handles customer inquiries, complaints, and support services.') -- 6
, ('Administration', 'Provides administrative support, office management, and facility maintenance.') -- 7
, ('Operations', 'Manages day-to-day operations, production processes, and logistics.') -- 8
, ('Legal', 'Provides legal advice, handles contracts, and ensures compliance with regulations.') -- 9
, ('Public Relations', 'Manages company image, media relations, and public communications.') -- 10
; 




INSERT INTO employees (first_name, last_name, department_id, office_id) 
VALUES 
  ('John', 'Doe', 9, 3)
, ('Jane', 'Smith', 9, 3)
, ('Michael', 'Brown', 9, 3)
, ('Emily', 'Davis', 9, 3)
, ('Chris', 'Miller', 9, 3)
, ('Sarah', 'Wilson', 9, 3)
, ('David', 'Moore', 9, 3)
, ('Laura', 'Taylor', 9, 3)
, ('Daniel', 'Anderson', 9, 3)
, ('Hannah', 'Thomas', 9, 3)
, ('Matthew', 'Jackson', 9, 3)
, ('Olivia', 'White', 9, 3)
, ('Joshua', 'Harris', 9, 3)
, ('Jessica', 'Martin', 9, 3)
, ('Ethan', 'Thompson', 9, 3)
, ('Sophia', 'Garcia', 9, 3)
, ('Benjamin', 'Martinez', 9, 3)
, ('Isabella', 'Robinson', 9, 3)
, ('Mia', 'Rodriguez', 9, 3)
, ('Jack', 'Lewis', 10, 3)
, ('Lily', 'Lee', 10, 3)
, ('Andrew', 'Walker', 10, 3)
, ('Grace', 'Hall', 10, 3)
, ('James', 'Allen', 10, 3)
, ('Chloe', 'Young', 10, 3)
, ('Jon', 'Provan', 5, 3)
;
