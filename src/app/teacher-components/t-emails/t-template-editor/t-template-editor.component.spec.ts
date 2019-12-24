import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TTemplateEditorComponent } from './t-template-editor.component';

describe('TTemplateEditorComponent', () => {
  let component: TTemplateEditorComponent;
  let fixture: ComponentFixture<TTemplateEditorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TTemplateEditorComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TTemplateEditorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
