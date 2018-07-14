import { Component } from '@angular/core';
import {NgForm} from '@angular/forms';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  courses = [
    {
      courseid : 101,
      cname : 'Angular 6',
      duration : 60,
      fees : 10000.00
    },
    {
      courseid : 102,
      cname : 'ReactJS 16.3',
      duration : 60,
      fees : 12000.00
    },
    {
      courseid : 103,
      cname : 'NodeJS',
      duration : 60,
      fees : 15000.00
    },
    {
      courseid : 104,
      cname : 'MongoDB',
      duration : 60,
      fees : 9000.00
    }
  ];


  rating = 4.3452677;
  amount = 2300;
  birthday = new Date();

departments = [
  {
    depName: 'IT',
    Hod: 'A K Pandey',
    Intake: 150,
    professors: 4
  },
  {
    depName: 'CSE',
    Hod: 'XYZ',
    Intake: 190,
    professors: 6
  },
  {
    depName: 'CIVIL',
    Hod: 'ABC',
    Intake: 120,
    professors: 5
  },
  {
    depName: 'ECE',
    Hod: 'ZYX',
    Intake: 100,
    professors: 4
  },
];





  servers = [
    {
      instanceType: 'medium',
      name: 'Production Server',
      status: 'stable',
      started: new Date(15, 1, 2017)
    },
    {
      instanceType: 'large',
      name: 'User Database',
      status: 'stable',
      started: new Date(15, 1, 2017)
    },
    {
      instanceType: 'small',
      name: 'Development Server',
      status: 'offline',
      started: new Date(15, 1, 2017)
    },
    {
      instanceType: 'small',
      name: 'Testing Environment Server',
      status: 'stable',
      started: new Date(15, 1, 2017)
    }
  ];
  getStatusClasses(server: {instanceType: string, name: string, status: string, started: Date}) {
    return {
      'list-group-item-success': server.status === 'stable',
      'list-group-item-warning': server.status === 'offline',
      'list-group-item-danger': server.status === 'critical'
    };
  }

 



}
