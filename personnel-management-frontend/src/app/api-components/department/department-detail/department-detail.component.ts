import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Department } from '../../../models/department';
import { ActivatedRoute } from '@angular/router';
import { HttpService } from '../../../services/http.service';

@Component({
  selector: 'app-department-detail',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './department-detail.component.html',
  styleUrl: './department-detail.component.css'
})
export class DepartmentDetailComponent {

  //department to show the detail of
  dept: Department = new Department(0,'',[]);

  //for holding and modeling department updates
  updatedDepartment: Department = new Department(0,'',[]);

  //Activated Route and Http Service so we can get access to values of the route and the url
  constructor(private route: ActivatedRoute, private httpService: HttpService) 
  {
    this.getDepartmentById();
  }

  getDepartmentById()
  {
    this.httpService
    .getDepartmentById(this.route.snapshot.params['id'])
    .subscribe(data => {
      this.dept = data.body;

      this.updatedDepartment.departmentId = data.body.departmentId;
      this.updatedDepartment.departmentName = data.body.departmentName;
    });
  }

  //updates our current department
  updateDepartment()
  {
    this.httpService
    .updateDepartment(this.updatedDepartment)
    .subscribe(data => {
      this.getDepartmentById();
    })
  }





}
