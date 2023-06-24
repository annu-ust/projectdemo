import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/model/User';
import { AuthserviceService } from 'src/app/services/authservice.service';
import { UserService } from 'src/app/services/user.service';



@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  user:User=new User();
  
 

  constructor(private router: Router,private service:UserService,private authService:AuthserviceService) { }

 
  login() {
    
    const { email, password } = this.user;
    this.authService.login(email, password);
    
  }

  getUserRole() {
    // Get the user role from localStorage
    return localStorage.getItem('userRole');
  }
  
  // login(email: string, password: string) {
  //   this.service.fetchUser(this.user).subscribe((data)=>{
  //     this.user = new User();
      
  //     this.router.navigate(['/']);
    
  //     });
   
   
  // }
    navigateToReset() {
      this.router.navigateByUrl('/reset-password');
    }
  
  
}
