import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ComposeEdmComponent } from './compose-edm.component';

describe('ComposeEdmComponent', () => {
  let component: ComposeEdmComponent;
  let fixture: ComponentFixture<ComposeEdmComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ComposeEdmComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ComposeEdmComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
