import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TReportsComponent } from './t-reports.component';

describe('TReportsComponent', () => {
  let component: TReportsComponent;
  let fixture: ComponentFixture<TReportsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TReportsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TReportsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
