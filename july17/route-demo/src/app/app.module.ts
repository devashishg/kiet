import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { AddEmpComponent } from './home/add-emp/add-emp.component';
import { EditEmpComponent } from './home/edit-emp/edit-emp.component';
import { GetEmpComponent } from './home/get-emp/get-emp.component';
import { SignupComponent } from './signup/signup.component';
import {RouterModule, Routes} from '@angular/router';
import {FormsModule} from '@angular/forms';

const appRoutes: Routes = [
  {
    path: '',
    component: LoginComponent
  },
  {
    path: 'login',
    component: LoginComponent
  },
   {
    path: 'signup',
    component: SignupComponent
  },
  {
    path: 'home',
    component: HomeComponent,
    children : [
      {
        path : 'addemp',
        component: AddEmpComponent
      },
      {
        path : 'editemp',
        component: EditEmpComponent
      },
      {
        path : 'getemp',
        component: GetEmpComponent
      }
    ]
  }
];

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    AddEmpComponent,
    EditEmpComponent,
    GetEmpComponent,
    SignupComponent
    ],
  imports: [
    BrowserModule,
    FormsModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
