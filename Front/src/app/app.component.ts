import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {

  title = 'HERCULES';
  isAuthenticated = false;

  logIn(){
    this.isAuthenticated = true;
  }

  logOut() {
    this.isAuthenticated = false;
  }

}
