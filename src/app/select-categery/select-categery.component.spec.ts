import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SelectCategeryComponent } from './select-categery.component';

describe('SelectCategeryComponent', () => {
  let component: SelectCategeryComponent;
  let fixture: ComponentFixture<SelectCategeryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SelectCategeryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SelectCategeryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
