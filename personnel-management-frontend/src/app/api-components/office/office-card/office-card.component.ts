import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Router } from '@angular/router';
import { Office } from '../../../models/office';

@Component({
  selector: 'app-office-card',
  standalone: true,
  imports: [],
  templateUrl: './office-card.component.html',
  styleUrl: './office-card.component.css'
})
export class OfficeCardComponent {

  //could use a data pass service in constructor if needed (as in class example)
  constructor( private router: Router ) {}

  //value will be passed in from parent class
  @Input() office: Office = new Office(0,'','','','','',0,0,[]);

  //parent will listen for event to allow action to take place
  @Output() deleteOfficeEvent = new EventEmitter<number>();

  //method to delete office which sends event
  deleteThisOffice()
  {
    this.deleteOfficeEvent.emit(this.office.officeId);
  }

  //method to go to office info screen. Moves user to the detail page for this office
  viewOffice()
  {
    this.router.navigate(['office/' + this.office.officeId])
  }
  
}
