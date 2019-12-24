import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { YourClassroomComponent } from './your-classroom.component';

describe('YourClassroomComponent', () => {
  let component: YourClassroomComponent;
  let fixture: ComponentFixture<YourClassroomComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ YourClassroomComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(YourClassroomComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
