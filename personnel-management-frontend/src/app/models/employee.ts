import { Department } from "./department";
import { Office } from "./office";

export class Employee 
{
    employeeId: number;
    firstName: string;
    lastName: string;
    department: any;    
    office: any;

    constructor(
          employeeId: number
        , firstName: string
        , lastName: string
        , department: any
        , office: any
    )
    {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.office = office;
    }






}
