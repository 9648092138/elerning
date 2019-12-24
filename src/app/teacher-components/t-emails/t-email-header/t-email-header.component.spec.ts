import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TEmailHeaderComponent } from './t-email-header.component';

describe('TEmailHeaderComponent', () => {
  let component: TEmailHeaderComponent;
  let fixture: ComponentFixture<TEmailHeaderComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TEmailHeaderComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TEmailHeaderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
