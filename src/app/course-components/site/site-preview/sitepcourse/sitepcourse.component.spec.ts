import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SitepcourseComponent } from './sitepcourse.component';

describe('SitepcourseComponent', () => {
  let component: SitepcourseComponent;
  let fixture: ComponentFixture<SitepcourseComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SitepcourseComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SitepcourseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
