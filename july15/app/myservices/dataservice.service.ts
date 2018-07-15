import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable()
export class DataService {

    empUrl = 'http://localhost:8282/MockProject/demo';

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
}
