import { HttpClient, HttpParams, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Department } from '../models/department';
import { Office } from '../models/office';
import { Employee } from '../models/employee';

/*
  establishes connection to API
  we'll have our methods here so we can use them on front end
*/

@Injectable({
  providedIn: 'root'
})
export class HttpService 
{

  constructor(private http: HttpClient) { }

  url: string = 'http://localhost:8080/';


  /***office methods***/
  //CREATE / POST
  addOffice(office: Office): Observable<HttpResponse<any>>
  {
    return this.http.post(
      this.url + 'office', office, {observe:'response'} //using observable's http response
    );
  }

  //READ / GET
  getAllOffices()
  {
    return this.http.get(
      this.url + 'office', {observe:'response'}
    );
  }

  getOfficeById(officeId: number)
  {
    return this.http.get(
      this.url + 'office/' + officeId, {observe:'response'}
    )
  }

  //UPDATE / PUT
  updateOffice(office: Office): Observable<HttpResponse<any>>
  {
    return this.http.put(
      this.url + 'office/' + office.officeId, office, { observe: 'response' }
    );
  }

  //DELETE
  //need to put logic in api to check that no employees are in this office before deleting it
  deleteOffice(officeId: number): Observable<HttpResponse<any>>
  {
    return this.http.delete(this.url + 'office/' + officeId, { observe: 'response' });
  }
  
  /***department methods***/
  //CREATE / POST
  addDepartment(department: Department): Observable<HttpResponse<any>>
  {
    return this.http.post(
      this.url + 'department', department, {observe : 'response'}  
    );
    
  }

  //READ / GET
  getAllDepartments(): Observable<HttpResponse<any>>
  {
    return this.http.get(
      this.url + 'department', {observe: 'response'}
    );
  }

  getDepartmentById(departmentId: number): Observable<HttpResponse<any>>
  {
    return this.http.get(
      this.url + 'department/' + departmentId, { observe:'response'}
    );
  }

  //UPDATE / PUT
  updateDepartment(department: Department): Observable<HttpResponse<any>>
  {
   
    return this.http.put(
      this.url + 'department/' + department.departmentId, department, { observe: 'response' }
    );
  }

  //DELETE / DELETE
  //need to put logic on backend to check that no employees are in a department before deleting it
  deleteDepartment(departmentId: number): Observable<HttpResponse<any>>
  {
    return this.http.delete(this.url + 'department/' + departmentId, {observe: 'response'});
  }

  /*** employee methods ***/
  //CREATE / POST
  addEmployee(employee: Employee): Observable<HttpResponse<any>>
  {
    return this.http.post(
      this.url + 'employee', employee, { observe: 'response' }
    );
  }

  //READ / GET
  getAllEmployees(): Observable<HttpResponse<any>>
  {
    return this.http.get(
      this.url + 'employee', { observe: 'response' }
    );
  }

  getEmployeeById(employeeId: number): Observable<HttpResponse<any>>
  {
    return this.http.get(
      this.url + 'employee/' + employeeId, { observe: 'response' }
    );
  }

  //UPDATE / PUT
  updateEmployee(employee: Employee): Observable<HttpResponse<any>>
  {
    return this.http.put(
      this.url + 'employee/' + employee.employeeId, employee, { observe: 'response' }
    );
  }

  //DELETE
  deleteEmployee(employeeId: number): Observable<HttpResponse<any>>
  {
    return this.http.delete(this.url + 'employee/' + employeeId, { observe: 'response' });
  }
  
}
