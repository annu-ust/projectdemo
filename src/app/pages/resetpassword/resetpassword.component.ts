import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/model/User';

@Component({
  selector: 'app-resetpassword',
  templateUrl: './resetpassword.component.html',
  styleUrls: ['./resetpassword.component.css']
})
export class ResetpasswordComponent {
  user:User=new User();
  email!: User["email"];
  password!: string;
  confirmPassword!: string;
  constructor(private router: Router) { }
  resetPassword() {
    // Implement the password reset logic here
  }
  reset(){
    this.router.navigate(['/login']);
  }
}
