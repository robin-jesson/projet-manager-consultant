import { Input, Output, EventEmitter } from '@angular/core';
import { FormControl, FormGroupDirective, NgForm } from '@angular/forms';
import { ErrorStateMatcher } from '@angular/material/core';

class MyErrStateMatcher implements ErrorStateMatcher {
    isErrorState(control: FormControl | null, form: FormGroupDirective | NgForm | null): boolean {
      const isSubmitted = form && form.submitted;
      return !!(control && control.invalid && (control.dirty || control.touched));
    }
}

export abstract class FormField {

    @Input() appearance : String = 'standard';
    @Input() placeholder : String;
    
    @Output('dirty') emitter = new EventEmitter<FormControl>();

    errStateMatcher : ErrorStateMatcher = new MyErrStateMatcher();
    formCtrl : FormControl;

    constructor(formCtrl : FormControl) {
        this.formCtrl = formCtrl;
    }

    onInput() { this.emitter.emit(this.formCtrl); }
    
}
