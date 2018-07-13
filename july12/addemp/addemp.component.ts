import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-addemp',
  templateUrl: './addemp.component.html',
  styleUrls: ['./addemp.component.css']
})
export class AddempComponent implements OnInit {

  addEmpUrl = 'http://localhost:8282/MockProject/demo';

  constructor(public http: HttpClient) {
    }

  ngOnInit() {
  }

  onAddEmployee(empForm) {
    console.log(empForm.value);

    this.http.post(this.addEmpUrl, JSON.stringify(empForm.value))
        .subscribe( (response) => {
           console.log(response);
       } );

  }

}
