import { Component, OnInit, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {

  @Output() logOut = new EventEmitter<any>();

  constructor() { }

  ngOnInit(): void {
  }

  onLogOut() {
    this.logOut.emit();
  }

}
