import { Component, Inject, PLATFORM_ID } from '@angular/core';
import { isPlatformBrowser } from '@angular/common';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent {
  loginMenu: string = "Login"; // Default text
  showLoginForm: boolean = false;
  isLoggedIn: boolean = false;
  username: string | null = null;
  selectedPriceRange: string = '';
  searchQuery: string = '';  // Fix: Add this property

  constructor(@Inject(PLATFORM_ID) private platformId: object) {
    if (isPlatformBrowser(this.platformId)) {
      // Check localStorage for existing login session
      const storedUser = localStorage.getItem('username');
      if (storedUser) {
        this.username = storedUser;
        this.loginMenu = `${this.username} | Logout`;
        this.isLoggedIn = true;
      }
    }
  }

  loginHandler() {
    if (this.isLoggedIn) {
      // If user is logged in, perform logout
      this.logout();
    } else {
      // Show login form
      this.showLoginForm = true;
    }
  }

  onLogin(username: string) {
    if (isPlatformBrowser(this.platformId)) {
      localStorage.setItem('username', username);
    }
    this.username = username;
    this.loginMenu = `${this.username} | Logout`;
    this.isLoggedIn = true;
    this.showLoginForm = false;
  }

  logout() {
    if (isPlatformBrowser(this.platformId)) {
      localStorage.removeItem('username');
    }
    this.username = null;
    this.loginMenu = "Login";
    this.isLoggedIn = false;
  }
}
