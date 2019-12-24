import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SetAssignmentComponent } from './set-assignment.component';

describe('SetAssignmentComponent', () => {
  let component: SetAssignmentComponent;
  let fixture: ComponentFixture<SetAssignmentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SetAssignmentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SetAssignmentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
