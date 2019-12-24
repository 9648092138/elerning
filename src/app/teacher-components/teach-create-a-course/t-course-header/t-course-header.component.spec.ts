import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TCourseHeaderComponent } from './t-course-header.component';

describe('TCourseHeaderComponent', () => {
  let component: TCourseHeaderComponent;
  let fixture: ComponentFixture<TCourseHeaderComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TCourseHeaderComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TCourseHeaderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
