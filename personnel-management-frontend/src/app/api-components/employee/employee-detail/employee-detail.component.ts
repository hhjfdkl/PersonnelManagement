import { Component } from '@angular/core';
import { Employee } from '../../../models/employee';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { ActivatedRoute } from '@angular/router';
import { HttpService } from '../../../services/http.service';

@Component({
  selector: 'app-employee-detail',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './employee-detail.component.html',
  styleUrl: './employee-detail.component.css'
})
export class EmployeeDetailComponent {

  
  //employee to show the detail of
  ee: Employee = new Employee(0,'','',null,null);

  //for holding and modeling employee updates
  updatedEmployee: Employee = new Employee(0,'','',null,null);

  //Activated Route and Http Service so we can get access to values of the route and the url
  constructor(private route: ActivatedRoute, private httpService: HttpService) 
  {
    this.getEmployeeById();
  }

  getEmployeeById()
  {
    this.httpService
    .getEmployeeById(this.route.snapshot.params['id'])
    .subscribe(data => {
      this.ee = data.body;

      this.updatedEmployee.employeeId = data.body.employeeId;
      this.updatedEmployee.firstName = data.body.firstName;
      this.updatedEmployee.lastName = data.body.lastName;
      this.updatedEmployee.department = data.body.department;
      this.updatedEmployee.office = data.body.office;
    });
  }

  //updates our current employee
  updateEmployee()
  {
    this.httpService
    .updateEmployee(this.updatedEmployee)
    .subscribe(data => {
      this.getEmployeeById();
    })
  }


}
