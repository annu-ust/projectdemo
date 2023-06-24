import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthserviceService } from 'src/app/services/authservice.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {

  
  constructor(private userService: UserService,private router:Router,private authservice:AuthserviceService) {
    
  }
  
  isLoggedIn(): boolean {
    
    return this.authservice.isAuthenticatedUser();}
 

  toggleLogin() {
    if (this.isLoggedIn()) {
      this.authservice.setAuthenticated(false);
      this.authservice.logout();
      
    } else {
      this.router.navigate(['/login']);
    }
  }
  
}
