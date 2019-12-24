import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TTemplateComponent } from './t-template.component';

describe('TTemplateComponent', () => {
  let component: TTemplateComponent;
  let fixture: ComponentFixture<TTemplateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TTemplateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TTemplateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
