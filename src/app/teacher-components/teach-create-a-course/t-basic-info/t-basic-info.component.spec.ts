import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TBasicInfoComponent } from './t-basic-info.component';

describe('TBasicInfoComponent', () => {
  let component: TBasicInfoComponent;
  let fixture: ComponentFixture<TBasicInfoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TBasicInfoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TBasicInfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
