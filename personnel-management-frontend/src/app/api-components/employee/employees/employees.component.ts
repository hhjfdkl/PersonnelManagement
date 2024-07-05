import { Component } from '@angular/core';
import { Employee } from '../../../models/employee';
import { CommonModule } from '@angular/common';
import { EmployeeCardComponent } from '../employee-card/employee-card.component';
import { FormsModule } from '@angular/forms';
import { HttpService } from '../../../services/http.service';

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

  

  formEmployee: Employee = new Employee(0,'','',null,null); //for our add employee method
  formEmployeeId: number = 0; //base value for our get dept by id form
  employeeNotThere: boolean = false; //bool to change to true if we don't find anything from our db

  constructor(private httpService: HttpService)
  {
    this.getAllEmployees();
  }

  //CREATE / POST
  addEmployee()
  {
    this.httpService
    .addEmployee(this.formEmployee)
    .subscribe(data => {
      this.getAllEmployees();
    });
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
