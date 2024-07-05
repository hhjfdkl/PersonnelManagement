import { Employee } from "./employee";

export class Department 
{


    departmentId: number;
    departmentName: string;
    employees: any[];

    constructor(
          departmentId: number
        , departmentName: string
        , employees: any[]
    )
    {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.employees = employees;
    }

    getLimitedEmployees(startIndex: number, endIndex: number): any[]
    {
        return this.employees.slice(startIndex, endIndex);
    }

}
