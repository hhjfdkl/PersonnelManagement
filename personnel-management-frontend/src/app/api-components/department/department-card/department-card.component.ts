import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Department } from '../../../models/department';
import { Router } from '@angular/router';

@Component({
  selector: 'app-department-card',
  standalone: true,
  imports: [],
  templateUrl: './department-card.component.html',
  styleUrl: './department-card.component.css'
})

export class DepartmentCardComponent { 

//could use a data pass service in constructor if needed (as in class example)
constructor( private router: Router) {}

//value will be passed in from parent class
@Input() department: Department = new Department(0, 'test', [ { employeeFirstName: 'test'} ]);

//parent will listen for event to allow action to take place
@Output() deleteDepartmentEvent = new EventEmitter<number>();

//method to delete department
deleteThisDepartment()
{
  this.deleteDepartmentEvent.emit(this.department.departmentId);
}

//method to update department
editDepartment()
{
  this.router.navigate(['department/' + this.department.departmentId])
}



}
