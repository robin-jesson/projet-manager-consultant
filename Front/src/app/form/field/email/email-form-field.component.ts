import { FormField } from './../FormField';
import { FormControl, Validators } from '@angular/forms';
import { Component } from '@angular/core';

@Component({
  selector: 'app-email-form-field',
  templateUrl: './email-form-field.component.html',
  styleUrls: ['./email-form-field.component.scss']
})
export class EmailFormFieldComponent extends FormField {
  constructor() {
    super(new FormControl('', [
      Validators.required,
      Validators.pattern('[a-zA-Z]+\\.[a-zA-Z]+@alten\\.com')
    ]));
  }
}