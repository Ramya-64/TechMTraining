import { Component, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  username: string = '';
  password: string = '';

  @Output() closeForm = new EventEmitter<void>();
  @Output() loggedIn = new EventEmitter<string>();

  login() {
    if (this.username && this.password) {
      this.loggedIn.emit(this.username); // Send username to menu
      this.closeForm.emit(); // Close login form
    }
  }
}
