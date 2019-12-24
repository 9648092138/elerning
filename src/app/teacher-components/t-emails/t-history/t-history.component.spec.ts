import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { THistoryComponent } from './t-history.component';

describe('THistoryComponent', () => {
  let component: THistoryComponent;
  let fixture: ComponentFixture<THistoryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ THistoryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(THistoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
