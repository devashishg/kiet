import { DataService } from './../myservices/dataservice.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-edit-emp',
  templateUrl: './edit-emp.component.html',
  styleUrls: ['./edit-emp.component.css']
})
export class EditEmpComponent implements OnInit {

  constructor(public ds: DataService) { }

  ngOnInit() {
  }

  onUpdate() {
    // console.log('update button clicked');
    this.ds.updateEmployee()
        .subscribe(
          (response) => {
            console.log(response);
          }
        );
  }

  onDelete() {
   // console.log('delete button clicked');
   this.ds.deleteEmployee()
      .subscribe((response) => {
         console.log(response);
      });
  }
}
