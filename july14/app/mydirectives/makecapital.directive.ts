import { Directive, ElementRef, HostListener } from '@angular/core';

@Directive({
  selector: '[makeCapital]'
})
export class MakecapitalDirective {

  constructor(private eleRef: ElementRef) {
    /*eleRef.nativeElement.addEventListener('blur', () => {
      console.log(eleRef.nativeElement.value);
      this.eleRef.nativeElement.value = this.eleRef.nativeElement.value.toUpperCase();
    });*/
   }
 
  @HostListener('blur')
  makeCapitalLetters() {
      this.eleRef.nativeElement.value = this.eleRef.nativeElement.value.toUpperCase();
      console.log(this.eleRef.nativeElement.value);
  }
}
