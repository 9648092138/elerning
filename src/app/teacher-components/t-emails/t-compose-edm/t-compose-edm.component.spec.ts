import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TComposeEdmComponent } from './t-compose-edm.component';

describe('TComposeEdmComponent', () => {
  let component: TComposeEdmComponent;
  let fixture: ComponentFixture<TComposeEdmComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TComposeEdmComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TComposeEdmComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
