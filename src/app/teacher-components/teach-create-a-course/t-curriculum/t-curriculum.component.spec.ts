import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TCurriculumComponent } from './t-curriculum.component';

describe('TCurriculumComponent', () => {
  let component: TCurriculumComponent;
  let fixture: ComponentFixture<TCurriculumComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TCurriculumComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TCurriculumComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
