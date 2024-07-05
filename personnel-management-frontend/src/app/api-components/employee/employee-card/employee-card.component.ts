import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Router } from '@angular/router';
import { Employee } from '../../../models/employee';

@Component({
  selector: 'app-employee-card',
  standalone: true,
  imports: [],
  templateUrl: './employee-card.component.html',
  styleUrl: './employee-card.component.css'
})
export class EmployeeCardComponent {

  //could use a data pass service in constructor if needed (as in class example)
constructor( private router: Router ) {}

//value will be passed in from parent class
@Input() employee: Employee = new Employee(0,'','',null,null);

//parent will listen for event to allow action to take place
@Output() deleteEmployeeEvent = new EventEmitter<number>();

//method to delete employee which sends event
deleteThisEmployee()
{
  this.deleteEmployeeEvent.emit(this.employee.employeeId);
}

//method to go to employee info screen. Moves user to the detail page for this department
viewEmployee()
{
  this.router.navigate(['employee/' + this.employee.employeeId])
}


}
