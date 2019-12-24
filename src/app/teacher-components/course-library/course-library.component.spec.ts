import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CourseLibraryComponent } from './course-library.component';

describe('CourseLibraryComponent', () => {
  let component: CourseLibraryComponent;
  let fixture: ComponentFixture<CourseLibraryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CourseLibraryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CourseLibraryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
