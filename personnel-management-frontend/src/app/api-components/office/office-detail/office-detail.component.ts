import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Office } from '../../../models/office';
import { ActivatedRoute } from '@angular/router';
import { HttpService } from '../../../services/http.service';

@Component({
  selector: 'app-office-detail',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './office-detail.component.html',
  styleUrl: './office-detail.component.css'
})
export class OfficeDetailComponent {

    //office to show the detail of
    office: Office = new Office(0,'','','','','',0,0,[]);

    //for holding and modeling office updates
    updatedOffice: Office = new Office(0,'','','','','',0,0,[]);
  
    //Activated Route and Http Service so we can get access to values of the route and the url
    constructor(private route: ActivatedRoute, private httpService: HttpService) 
    {
      this.getOfficeById();
    }
  
    getOfficeById()
    {
      this.httpService
      .getOfficeById(this.route.snapshot.params['id'])
      .subscribe(data => {
        this.office = data.body;
  
        this.updatedOffice.officeId = data.body.officeId;
        this.updatedOffice.officeName = data.body.officeName;
        this.updatedOffice.address = data.body.address;
        this.updatedOffice.suite = data.body.suite;
        this.updatedOffice.city = data.body.city;
        this.updatedOffice.state = data.body.state;
        this.updatedOffice.zip = data.body.zip;
        this.updatedOffice.maxCapacity = data.body.maxCapacity;
        this.updatedOffice.employees = data.body.employees;
      });
    }
  
    //updates our current office
    updateOffice()
    {
      this.httpService
      .updateOffice(this.updatedOffice)
      .subscribe(data => {
        this.getOfficeById();
      })
    }
  
  
  
}
