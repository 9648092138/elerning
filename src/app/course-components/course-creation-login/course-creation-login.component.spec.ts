import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CourseCreationLoginComponent } from './course-creation-login.component';

describe('CourseCreationLoginComponent', () => {
  let component: CourseCreationLoginComponent;
  let fixture: ComponentFixture<CourseCreationLoginComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CourseCreationLoginComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CourseCreationLoginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
