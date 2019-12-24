import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SitepdetailsComponent } from './sitepdetails.component';

describe('SitepdetailsComponent', () => {
  let component: SitepdetailsComponent;
  let fixture: ComponentFixture<SitepdetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SitepdetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SitepdetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
