import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MenuDetailsService } from 'src/app/services/menu-details.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  constructor(private router:Router,private service:MenuDetailsService,private userService:UserService) { }
  foodData:any;
  
  ngOnInit(): void {
    this.foodData = this.service.foodDetails;
    
  }
  // orderNow(){
  //   this.router.navigateByUrl('menu');]                                                                                                                                                                                                      
  // }
  checkLogin() {
    if (!this.userService.isAuthenticated()) {
      this.router.navigateByUrl('/login');
    } else {
      this.router.navigateByUrl('/menu');
    }
}
}
