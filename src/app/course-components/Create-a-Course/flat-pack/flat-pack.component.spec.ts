import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FlatPackComponent } from './flat-pack.component';

describe('FlatPackComponent', () => {
  let component: FlatPackComponent;
  let fixture: ComponentFixture<FlatPackComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FlatPackComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FlatPackComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
