import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable()
export class DataService {

    empUrl = 'http://localhost:8282/MockProject/demo';
    loginUrl = 'http://localhost:8282/MockProject/login';

    loggedInEmployee = null;

    constructor(public http: HttpClient) {
    }

    public addNewEmployee(emp) {
      return  this.http.post(this.empUrl, JSON.stringify(emp));
    }

    public getAllEmployees() {
      return  this.http.get(this.empUrl);
    }

    public updateEmployee(emp) {
        return this.http.put(this.empUrl, JSON.stringify(emp));
    }

    public deleteEmployee() {
        return this.http.delete(this.empUrl);
    }

     public loggingService(msg) {
        console.log(msg);
    }

    public checkLogin(logindetails) {
        // write code to request server
      this.http.post(this.loginUrl, JSON.stringify(logindetails))
                    .subscribe(
                        (response) => {
                           this.loggedInEmployee = response;
                        }
                    );
        if (this.loggedInEmployee != null) {
                return 1;
        } else {
            return -1;
        }
    }
}
