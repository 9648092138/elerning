import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TCoursePrevComponent } from './t-course-prev.component';

describe('TCoursePrevComponent', () => {
  let component: TCoursePrevComponent;
  let fixture: ComponentFixture<TCoursePrevComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TCoursePrevComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TCoursePrevComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
