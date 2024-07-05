import { Component } from '@angular/core';
import { Employee } from '../../../models/employee';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { ActivatedRoute } from '@angular/router';
import { HttpService } from '../../../services/http.service';
import { Department } from '../../../models/department';
import { Office } from '../../../models/office';

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

  //for holding existing departments to add
  updatedDepartment: Department = new Department(0,'',[]);

  //for holding existing offices to add
  updatedOffice: Office = new Office(0, '','','','','',0,0,[]);

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
      this.updatedEmployee.department = this.updatedDepartment;
      this.updatedEmployee.office = this.updatedOffice;
      
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

  //getters for office and dept
  // getOfficeById()
  // {
  //   this.httpService
  //   .getOfficeById(this.route.snapshot.params['id'])
  //   .subscribe(data => {
  //     this.updatedOffice.officeId = data.body.officeId;
  //     this.updatedOffice.officeName = data.body.officeName;
  //     this.updatedOffice.address = data.body.address;
  //     this.updatedOffice.suite = data.body.suite;
  //     this.updatedOffice.city = data.body.city;
  //     this.updatedOffice.state = data.body.state;
  //     this.updatedOffice.zip = data.body.zip;
  //     this.updatedOffice.maxCapacity = data.body.maxCapacity;
  //     // this.updatedOffice.employees = data.body.employees;
  //   })
  // }
    //dept getter so we can grab department and set to employee

    formDepartment: Department = new Department(0,'',[]); //for our add department method
    formDepartmentId: number = 0; //base value for our get dept by id form
    departmentNotThere: boolean = false; //bool to change to true if we don't find anything from our db
    departmentSelected: boolean = false; //bool to change when dept is selected

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
            console.log(error);
            this.departmentSelected = false;
            this.departmentNotThere = true;
          },
          complete: () => console.log('Completed') //puts message to console when we successfully get a response
        }
      );
    }

      //to set data acquired from getter method for dept to our employee
    setFormEmployeeDepartment()
    {
      
      
        this.updatedEmployee.department.departmentId = this.formDepartment.departmentId;
        this.updatedEmployee.department.departmentName = this.formDepartment.departmentName;
        this.updatedEmployee.department.employees = this.formDepartment.employees;
        console.log(this.formDepartment.departmentName);
      
      
    }

    formOffice: Office = new Office(0,'','','','','',0,0,[]); //for our add office method
    formOfficeId: number = 0; //base value for our get office by id form
    officeNotThere: boolean = false; //bool to change to true if we don't find anything from our db
    officeSelected: boolean = false; //bool to change when office is selected

    getOfficeById() 
    {
      this.httpService.getOfficeById(this.formOfficeId).subscribe(
        { //using next / error in case we don't get anything back
          next: data => {
            // this.offices = [];
            // this.offices.push(data.body);
            this.officeSelected = true;
            this.formOffice = data.body;
            this.officeNotThere = false;
            console.log('successfully pulled office by Id');
          },
          error: error => {
            console.log(error);
            this.officeSelected = false;
            this.officeNotThere = true;
          },
          complete: () => console.log('Completed') //puts message to console when we successfully get a response
        }
      );
    }

    //to set data acquired from getter method for office to our employee
  setFormEmployeeOffice()
  {
      this.updatedEmployee.office.officeId = this.formOffice.officeId;
      this.updatedEmployee.office.officeName = this.formOffice.officeName;
      this.updatedEmployee.office.address = this.formOffice.address;
      this.updatedEmployee.office.suite = this.formOffice.suite;
      this.updatedEmployee.office.city = this.formOffice.city;
      this.updatedEmployee.office.state = this.formOffice.state;
      this.updatedEmployee.office.zip = this.formOffice.zip;
      this.updatedEmployee.office.maxCapacity = this.formOffice.maxCapacity;
      this.updatedEmployee.office.employees = this.formOffice.employees;
    
    
  }

  // getDepartmentById()
  // {
  //   this.httpService
  //   .getDepartmentById(this.route.snapshot.params['id'])
  //   .subscribe(data => {
  //     this.updatedDepartment.departmentId = data.body.departmentId;
  //     this.updatedDepartment.departmentName = data.body.departmentName;
  //   });
  // }

}
