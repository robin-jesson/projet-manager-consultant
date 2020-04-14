import { Component, Output, EventEmitter } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-connexion-form',
  templateUrl: './connexion-form.component.html',
  styleUrls: ['./connexion-form.component.scss']
})
export class ConnexionFormComponent {

  @Output() authentication = new EventEmitter<any>();
  formGrp : FormGroup;
  hidden : Boolean;

  constructor() { 
    this.formGrp = new FormBuilder().group({id : '', password : ''});
    this.hidden = true;
  }

  onVisibility() : void { this.hidden = !this.hidden; }

  onLogIn() : void {

    console.log(this.formGrp.value['id']);
    console.log(this.formGrp.value['password']);
    this.authentication.emit();

  }
}
