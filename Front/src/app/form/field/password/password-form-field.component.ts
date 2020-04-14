import { FormField } from './../FormField';
import { Component } from '@angular/core';
import { FormControl, Validators, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-password-form-field',
  templateUrl: './password-form-field.component.html',
  styleUrls: ['./password-form-field.component.scss']
})
export class PasswordFormFieldComponent extends FormField {

  hidden : Boolean;

  constructor() {
    super(new FormControl('', [
      Validators.required
    ]));

    this.hidden = true;
  }

  onVisibility() : void { this.hidden = !this.hidden; }

}
