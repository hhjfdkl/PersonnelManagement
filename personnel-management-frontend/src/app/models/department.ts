export class Department 
{


    departmentId: number;
    departmentName: string;
    employees: object[];

    constructor(
          departmentId: number
        , departmentName: string
        , employees: object[]
    )
    {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.employees = employees;
    }


}
