import { Employee } from "./employee";

export class Office 
{
    officeId: number;
    officeName: string;
    address: string;
    suite: string;
    city: string;
    state: string;
    zip: number;
    maxCapacity: number;
    employees: any[];

    constructor(
          officeId: number
        , officeName:string
        , address: string
        , suite: string
        , city:string
        , state: string
        , zip:number
        , maxCapacity:number
        , employees:any[]
    )
    {
        this.officeId = officeId;
        this.officeName = officeName;
        this.address = address;
        this.suite = suite;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.maxCapacity = maxCapacity;
        this.employees = employees;

    }




}
