import { DataService } from './../myservices/dataservice.service';
import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  invalidUser = false;

  constructor(public route: Router, public ds: DataService) {

   }

  ngOnInit() {
  }

  onLogin(loginForm) {

   // console.log(loginForm.value);

    if (this.ds.checkLogin(loginForm.value) === 1) {
        this.route.navigate(['home']);
    }
  }
}
