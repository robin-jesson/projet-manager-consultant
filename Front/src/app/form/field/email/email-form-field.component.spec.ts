import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmailFormFieldComponent } from './email-form-field.component';

describe('EmailFormCtrlComponent', () => {
  let component: EmailFormFieldComponent;
  let fixture: ComponentFixture<EmailFormFieldComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmailFormFieldComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmailFormFieldComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
