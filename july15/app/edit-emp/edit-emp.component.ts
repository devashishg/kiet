import { DataService } from './../myservices/dataservice.service';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';

@Component({
  selector: 'app-edit-emp',
  templateUrl: './edit-emp.component.html',
  styleUrls: ['./edit-emp.component.css']
})
export class EditEmpComponent implements OnInit {

  employees: any = [];
  currentEmp;

  empEditForm: FormGroup;

  constructor(public ds: DataService) {

      this.empEditForm = new FormGroup({
            empid : new FormControl(),
            ename : new FormControl(),
            city : new FormControl(),
            salary : new FormControl()
      });


      ds.getAllEmployees()
            .subscribe(
              (response) => {
                  this.employees = response;
                  console.log(this.employees);
            });

   }

   getEmployee(empid) {
      for (const emp of this.employees) {
          if (emp.empid == empid) {
              this.currentEmp = emp;
              break;
          }
      }
      if (this.currentEmp) {
          this.empEditForm.get('ename').setValue(this.currentEmp.ename);
          this.empEditForm.get('city').setValue(this.currentEmp.city);
          this.empEditForm.get('salary').setValue(this.currentEmp.salary);
      }
   }

  ngOnInit() {
  }

  onUpdate() {

    console.log(this.empEditForm.value);
    this.ds.updateEmployee(this.empEditForm.value)
        .subscribe(
          (response) => {
            console.log(response);
          }
        );
  }

  onDelete() {
   // console.log('delete button clicked');
   this.ds.deleteEmployee()
      .subscribe((response) => {
         console.log(response);
      });
  }
}
