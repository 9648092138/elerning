import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TeacherViewLoginComponent } from './teacher-view-login.component';

describe('TeacherViewLoginComponent', () => {
  let component: TeacherViewLoginComponent;
  let fixture: ComponentFixture<TeacherViewLoginComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TeacherViewLoginComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TeacherViewLoginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
