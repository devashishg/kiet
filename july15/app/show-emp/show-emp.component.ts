import { DataService } from './../myservices/dataservice.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-show-emp',
  templateUrl: './show-emp.component.html',
  styleUrls: ['./show-emp.component.css']
})
export class ShowEmpComponent implements OnInit {

  public employees: any = [];

  constructor(public ds: DataService) {

      this.ds.getAllEmployees()
        .subscribe(
          (response) => {
            // console.log(response);
            this.employees = response;
          }
        );
   }

  ngOnInit() {
  }

}
