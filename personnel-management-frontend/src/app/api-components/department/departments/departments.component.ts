import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { DepartmentCardComponent } from '../department-card/department-card.component';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-departments',
  standalone: true,
  imports: [CommonModule, DepartmentCardComponent, FormsModule],
  templateUrl: './departments.component.html',
  styleUrl: './departments.component.css'
})
export class DepartmentsComponent {

}
