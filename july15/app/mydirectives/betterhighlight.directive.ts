import { Directive, HostListener, HostBinding, OnInit, ElementRef, Renderer2 } from '@angular/core';

@Directive({
  selector: '[appBetterhighlight]'
})
export class BetterhighlightDirective implements OnInit {

  @HostBinding('style.backgroundColor')
  bgColor = 'lightblue';

  constructor(private ele: ElementRef, private renderer: Renderer2) {
  }

  ngOnInit() {
    // this.renderer.setStyle(this.ele.nativeElement, 'background-color', 'lightblue');
  }

  @HostListener('mouseover')
  onMouseOver() {
      this.bgColor = 'red';
  }

@HostListener('mouseout')
  onMouseOut() {
      this.bgColor = 'lightblue';
  }
}
