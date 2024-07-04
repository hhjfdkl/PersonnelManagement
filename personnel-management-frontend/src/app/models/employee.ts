export class Employee 
{
    employeeId: number;
    firstName: string;
    lastName: string;
    department: object;    
    office: object;

    constructor(
          employeeId: number
        , firstName: string
        , lastName: string
        , department: object
        , office: object
    )
    {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.office = office;
    }






}
