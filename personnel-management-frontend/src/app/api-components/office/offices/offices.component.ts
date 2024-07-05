import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { OfficeCardComponent } from '../office-card/office-card.component';
import { FormsModule } from '@angular/forms';
import { Office } from '../../../models/office';
import { HttpService } from '../../../services/http.service';

@Component({
  selector: 'app-offices',
  standalone: true,
  imports: [CommonModule, OfficeCardComponent, FormsModule],
  templateUrl: './offices.component.html',
  styleUrl: './offices.component.css'
})
export class OfficesComponent {

  offices: Office[] = [];
  officeIds: number[] = [];
  officeNames: string[] = [];

  

  formOffice: Office = new Office(0,'','','','','',0,0,[]); //for our add office method
  formOfficeId: number = 0; //base value for our get office by id form
  officeNotThere: boolean = false; //bool to change to true if we don't find anything from our db

  constructor(private httpService: HttpService)
  {
    this.getAllOffices();
  }

  //CREATE / POST
  addOffice()
  {
    this.httpService
    .addOffice(this.formOffice)
    .subscribe(data => {
      this.getAllOffices();
    });
  }

  //READ / GET
  getAllOffices()
  {
    this.httpService.getAllOffices()
    .subscribe( data => {
      this.offices = [];
      this.officeIds = [];
      this.officeNames = [];
      this.officeNotThere = false;

      for(let item of data.body) {
        this.offices.push(
          new Office(item.officeId, item.officeName, item.address, item.suite, item.city, item.state, item.zip, item.maxCapacity, item.employees)
        );

        this.officeIds.push(item.officeId);
        this.officeNames.push(item.officeName);
        
      }
    });
  }

  getOfficeById() 
  {
    this.httpService.getOfficeById(this.formOfficeId).subscribe(
      { //using next / error in case we don't get anything back
        next: data => {
          this.offices = [];
          this.offices.push(data.body);
          this.officeNotThere = false;
          console.log('successfully pulled office by Id');
        },
        error: error => {
          console.log(error);
          this.officeNotThere = true;
        },
        complete: () => console.log('Completed') //puts message to console when we successfully get a response
      }
    );
  }



  //DELETE
  deleteOffice(officeId: number)
  {
    this.httpService
    .deleteOffice(officeId)
    .subscribe(data => {
      this.getAllOffices();
    });
  }
  
  //for listening from child event for a delete office event
  processDeleteEvent(officeId: number)
  {
    this.deleteOffice(officeId);
  }



  //used to check our office name input via case-insensitve search
  officeNameExists(officeName: string): boolean
  {
    let lowerOfficeNames: string[] = this.officeNames.map(name => name.toLowerCase());
    return lowerOfficeNames.includes(officeName.toLowerCase());
  }


}
