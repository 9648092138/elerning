import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TStudentsComponent } from './t-students.component';

describe('TStudentsComponent', () => {
  let component: TStudentsComponent;
  let fixture: ComponentFixture<TStudentsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TStudentsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TStudentsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
