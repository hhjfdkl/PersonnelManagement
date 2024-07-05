import { Component } from '@angular/core';
import { Employee } from '../../../models/employee';
import { CommonModule } from '@angular/common';
import { EmployeeCardComponent } from '../employee-card/employee-card.component';
import { FormsModule } from '@angular/forms';
import { HttpService } from '../../../services/http.service';
import { Office } from '../../../models/office';
import { Department } from '../../../models/department';

@Component({
  selector: 'app-employees',
  standalone: true,
  imports: [CommonModule, EmployeeCardComponent, FormsModule],
  templateUrl: './employees.component.html',
  styleUrl: './employees.component.css'
})

export class EmployeesComponent {
  employees: Employee[] = []; 
  employeeIds: number[] = []; 
  employeeNames: string[] = [];

  departments: Department[] = [];
  departmentIds: number[] = [];
  departmentNames: string[] = [];

  offices: Office[] = [];
  officeIds: number[] = [];
  officeNames: string[] = [];

  

  formOffice: Office = new Office(0,'','','','','',0,0,[]); //for our add office method
  formOfficeId: number = 0; //base value for our get office by id form
  officeNotThere: boolean = false; //bool to change to true if we don't find anything from our db
  officeSelected: boolean = false; //starts false for our display

  formDepartment: Department = new Department(0,'',[]); //for our add department method
  formDepartmentId: number = 0; //base value for our get dept by id form
  departmentNotThere: boolean = false; //bool to change to true if we don't find anything from our db
  departmentSelected: boolean = false;

  

  formEmployee: Employee = new Employee(0,'','',this.formDepartment,this.formOffice); //for our add employee method
  formEmployeeId: number = 0; //base value for our get dept by id form
  employeeNotThere: boolean = false; //bool to change to true if we don't find anything from our db

  constructor(private httpService: HttpService)
  {
    this.getAllEmployees();
  }

  //to set data acquired from getter method for dept to our employee
  setFormEmployeeDepartment()
  {
     
    
      this.formEmployee.department.departmentId = this.formDepartment.departmentId;
      this.formEmployee.department.departmentName = this.formDepartment.departmentName;
      this.formEmployee.department.employees = this.formDepartment.employees;
      console.log(this.formDepartment.departmentName);
    
    
  }

//to set data acquired from getter method for office to our employee
  setFormEmployeeOffice()
  {
      this.formEmployee.office.officeId = this.formOffice.officeId;
      this.formEmployee.office.officeName = this.formOffice.officeName;
      this.formEmployee.office.address = this.formOffice.address;
      this.formEmployee.office.suite = this.formOffice.suite;
      this.formEmployee.office.city = this.formOffice.city;
      this.formEmployee.office.state = this.formOffice.state;
      this.formEmployee.office.zip = this.formOffice.zip;
      this.formEmployee.office.maxCapacity = this.formOffice.maxCapacity;
      this.formEmployee.office.employees = this.formOffice.employees;
    
    
  }

  //dept getter so we can grab department and set to employee
  getDepartmentById() 
  {
    this.httpService.getDepartmentById(this.formDepartmentId).subscribe(
      { //using next / error in case we don't get anything back
        next: data => {
          // this.departments = [];
          // this.departments.push(data.body);
          this.departmentSelected = true;
          this.formDepartment = data.body;
          this.departmentNotThere = false;
          console.log('successfully pulled department by Id');
        },
        error: error => {
          this.departmentSelected = false;
          console.log(error);
          this.departmentNotThere = true;
        },
        complete: () => console.log('Completed') //puts message to console when we successfully get a response
      }
    );
  }

  //office getter so we can grab office and set to employee
  getOfficeById() 
  {
    this.httpService.getOfficeById(this.formOfficeId).subscribe(
      { //using next / error in case we don't get anything back
        next: data => {
          this.officeSelected = true;
          this.formOffice = data.body;
          this.officeNotThere = false;
          console.log('successfully pulled office by Id');
        },
        error: error => {
          this.officeSelected = false;
          console.log(error);
          this.officeNotThere = true;
        },
        complete: () => console.log('Completed') //puts message to console when we successfully get a response
      }
    );
  }

  

  //CREATE / POST
  addEmployee()
  {
    this.httpService
    .addEmployee(this.formEmployee)
    .subscribe(data => {
      this.getAllEmployees();
    });
    // this.setFormEmployeeDepartment();
    // this.setFormEmployeeOffice();
  }

  

  //READ / GET
  getAllEmployees()
  {
    this.httpService.getAllEmployees()
    .subscribe( data => {
      this.employees = [];
      this.employeeIds = [];
      this.employeeNames = [];
      this.employeeNotThere = false;

      for(let item of data.body) {
        this.employees.push(
          new Employee(item.employeeId, item.firstName, item.lastName, item.department, item.office)
        );

        this.employeeIds.push(item.employeeId);
        this.employeeNames.push(item.employeeName);
      }
    });
  }

  getEmployeeById() 
  {
    this.httpService.getEmployeeById(this.formEmployeeId).subscribe(
      { //using next / error in case we don't get anything back
        next: data => {
          this.employees = [];
          this.employees.push(data.body);
          this.employeeNotThere = false;
          console.log('successfully pulled employee by Id');
        },
        error: error => {
          console.log(error);
          this.employeeNotThere = true;
        },
        complete: () => console.log('Completed') //puts message to console when we successfully get a response
      }
    );
  }



  //DELETE
  deleteEmployee(employeeId: number)
  {
    this.httpService
    .deleteEmployee(employeeId)
    .subscribe(data => {
      this.getAllEmployees();
    });
  }
  
  //for listening from child event for a delete employee event
  processDeleteEvent(employeeId: number)
  {
    this.deleteEmployee(employeeId);
  }



  

}
