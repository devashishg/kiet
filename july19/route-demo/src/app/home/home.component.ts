import { DataService } from './../myservices/dataservice.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  currentEmployee;

  constructor(public ds: DataService) {
    if (this.ds.loggedInEmployee != null) {
        this.currentEmployee = this.ds.loggedInEmployee;
    }
  }

  ngOnInit() {
  }

}
