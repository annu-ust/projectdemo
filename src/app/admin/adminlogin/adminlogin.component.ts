import { Component } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from 'src/app/model/User';
import { AuthserviceService } from 'src/app/services/authservice.service';

@Component({
  selector: 'app-adminlogin',
  templateUrl: './adminlogin.component.html',
  styleUrls: ['./adminlogin.component.css']
})
export class AdminloginComponent {
  user:User=new User();
  
 

  constructor(private router: Router,private authService:AuthserviceService) { }

 
  login() {
    
   if(this.user.email==='uvwas@gmail.com'){
    this.router.navigateByUrl('/create');
   }else{
    alert("invalid login");
   }
    
  }
}
