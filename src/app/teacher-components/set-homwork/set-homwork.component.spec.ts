import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SetHomworkComponent } from './set-homwork.component';

describe('SetHomworkComponent', () => {
  let component: SetHomworkComponent;
  let fixture: ComponentFixture<SetHomworkComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SetHomworkComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SetHomworkComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
