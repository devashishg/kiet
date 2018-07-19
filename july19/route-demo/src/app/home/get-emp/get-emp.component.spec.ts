import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GetEmpComponent } from './get-emp.component';

describe('GetEmpComponent', () => {
  let component: GetEmpComponent;
  let fixture: ComponentFixture<GetEmpComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GetEmpComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GetEmpComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
