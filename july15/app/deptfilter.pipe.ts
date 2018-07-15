import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'deptfilter'
})
export class DeptfilterPipe implements PipeTransform {

  transform(departments: any[], intk = 150 ): any {

      const resultArray: any[] = [];
      for (const dept of departments) {
        if (dept.Intake >= intk) {
            resultArray.push(dept);
        }
      }
    return resultArray;
  }

}
