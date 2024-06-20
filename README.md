Project 1 (Due 07/05/2024)

# Personnel Management

# Objective:
Create a personnel management solution that will enable an administrator at 
a given company to manage the employees working at any of its offices. The 
administrator should possess the ability to view, add, remove, and alter any of the 
employees within that company’s office(s). The site should provide the 
administrative team an easy portal to do their job, so having clear and concise 
UI/UX is paramount. The application should also take into consideration possible 
edge cases such as offices having their own maximum capacity and handling the 
addition of employees that would cause the office to exceed its capacity.

# Functional Requirements:
• Must be a full-stack solution consisting of:
  o Angular frontend (HTML, CSS, TS)
  o Spring Boot (Java) backend
  o MySQL database
• Code should be available to a public GitHub repository
• Possesses all required CRUD functionality
• Handles edge cases effectively

# Non-Functional Requirements:
• Well documented code
• Code upholds industry best practices (SOLID/DRY)
• Industry-Grade UI (User Interface)
• Intuitive UX (User Experience)

# Bonus Objectives:
• World’s your oyster!


## Restating
• Personnel Manager - Manages employees working in various offices
• Only used by adminstrators
  - Admin wants to...
      - view
      - add
      - remove
      - alter
  - DB consists of...
      - employees
      - offices
      - departments (?) - not explicitly stated, but can be inferred
  

## Questions to answer
• What encompasses an employee?
  - EID, name, role, department, office
• What encompasses an office?
  - Has max number of employees

