import { DataService } from './../myservices/dataservice.service';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-addemp',
  templateUrl: './addemp.component.html',
  styleUrls: ['./addemp.component.css']
})
export class AddempComponent implements OnInit {


  constructor(public ds: DataService) {
  }

  ngOnInit() {
  }

  onAddEmployee(empForm) {

    this.ds.addNewEmployee(empForm.value)
          .subscribe(
              (response) => {
                  console.log(response);
            });
  }
}
