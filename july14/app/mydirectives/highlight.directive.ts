import {Directive, ElementRef} from '@angular/core';

@Directive({
    selector: '[highlight]'
})
export class HighLightDirective {
    constructor(ele: ElementRef) {
        // console.log(ele);
        ele.nativeElement.style.backgroundColor = 'yellow';
    }
}
