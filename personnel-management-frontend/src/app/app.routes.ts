import { Routes } from '@angular/router';
import { MainPageComponent } from './main-page/main-page.component';
import { DepartmentsComponent } from './api-components/department/departments/departments.component';
import { EmployeesComponent } from './api-components/employee/employees/employees.component';
import { OfficesComponent } from './api-components/office/offices/offices.component';
import { EmployeeDetailComponent } from './api-components/employee/employee-detail/employee-detail.component';
import { DepartmentDetailComponent } from './api-components/department/department-detail/department-detail.component';
import { OfficeDetailComponent } from './api-components/office/office-detail/office-detail.component';

export const routes: Routes = [

    //Home
    {
        path: '',
        component: MainPageComponent
    },

    //Office
    {
        path:'offices',
        component:OfficesComponent
    },
    {
        path:'office/:id',
        component:OfficeDetailComponent
    },

    //Department
    {
        path:'departments',
        component: DepartmentsComponent
    },
    {
        path:'department/:id',
        component:DepartmentDetailComponent
    },

    //Employee
    {
        path:'employees',
        component: EmployeesComponent
    },
    {
        path:'employee/:id',
        component: EmployeeDetailComponent
    }
    


];
