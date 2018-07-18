import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(public route: Router) {

   }

  ngOnInit() {
  }

  onLogin(loginForm) {
    // if login credentials are valid
          // navigate to home
          this.route.navigate(['home']);
  }
}
