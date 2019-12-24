import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HistoryEdmComponent } from './history-edm.component';

describe('HistoryEdmComponent', () => {
  let component: HistoryEdmComponent;
  let fixture: ComponentFixture<HistoryEdmComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HistoryEdmComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HistoryEdmComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
