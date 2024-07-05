import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { DepartmentCardComponent } from '../department-card/department-card.component';
import { FormsModule } from '@angular/forms';
import { Department } from '../../../models/department';
import { HttpService } from '../../../services/http.service';

@Component({
  selector: 'app-departments',
  standalone: true,
  imports: [CommonModule, DepartmentCardComponent, FormsModule],
  templateUrl: './departments.component.html',
  styleUrl: './departments.component.css'
})

export class DepartmentsComponent {


  departments: Department[] = [];
  departmentIds: number[] = [];
  departmentNames: string[] = [];

  

  formDepartment: Department = new Department(0,'',[]); //for our add department method
  formDepartmentId: number = 0; //base value for our get dept by id form
  departmentNotThere: boolean = false; //bool to change to true if we don't find anything from our db

  constructor(private httpService: HttpService)
  {
    this.getAllDepartments();
  }

  //CREATE / POST
  addDepartment()
  {
    this.httpService
    .addDepartment(this.formDepartment)
    .subscribe(data => {
      this.getAllDepartments();
    });
  }

  //READ / GET
  getAllDepartments()
  {
    this.httpService.getAllDepartments()
    .subscribe( data => {
      this.departments = [];
      this.departmentIds = [];
      this.departmentNames = [];
      this.departmentNotThere = false;

      for(let item of data.body) {
        this.departments.push(
          new Department(item.departmentId, item.departmentName, item.employees)
        );

        this.departmentIds.push(item.departmentId);
        this.departmentNames.push(item.departmentName);
      }
    });
  }

  getDepartmentById() 
  {
    this.httpService.getDepartmentById(this.formDepartmentId).subscribe(
      { //using next / error in case we don't get anything back
        next: data => {
          this.departments = [];
          this.departments.push(data.body);
          this.departmentNotThere = false;
          console.log('successfully pulled department by Id');
        },
        error: error => {
          console.log(error);
          this.departmentNotThere = true;
        },
        complete: () => console.log('Completed') //puts message to console when we successfully get a response
      }
    );
  }



  //DELETE
  deleteDepartment(departmentId: number)
  {
    this.httpService
    .deleteDepartment(departmentId)
    .subscribe(data => {
      this.getAllDepartments();
    });
  }
  
  //for listening from child event for a delete department event
  processDeleteEvent(departmentId: number)
  {
    this.deleteDepartment(departmentId);
  }



  //used to check our department name input via case-insensitve search
  departmentNameExists(departmentName: string): boolean
  {
    let lowerDeptNames: string[] = this.departmentNames.map(name => name.toLowerCase());
    return lowerDeptNames.includes(departmentName.toLowerCase());
  }



}
