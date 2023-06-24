import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CartserviceService } from 'src/app/services/cartservice.service';
import { MenuDetailsService } from 'src/app/services/menu-details.service';
import { UserService } from 'src/app/services/user.service';
import { CartComponent } from '../cart/cart.component';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  constructor(private service:MenuDetailsService,private cartService:CartserviceService,private router:Router,private userService:UserService) { }
  foodData:any;
  // ngOnInit(): void {
  //   this.foodData = this.service.foodDetails;
  // }
  filteredFoodData: any[] | undefined;
  searchQuery!: string;

  
  ngOnInit(): void {
    this.foodData = this.service.foodDetails;
    this.filteredFoodData = [...this.foodData];
  }

  search(): void {
    if (this.searchQuery) {
      this.filteredFoodData = this.foodData.filter(
        (fd: any) =>
          fd.foodName.toLowerCase().includes(this.searchQuery.toLowerCase())
      );
    } else {
      this.filteredFoodData = [...this.foodData];
    }
  }
  addToCart(food: any) {
    if (!this.userService.isAuthenticated()) {
      this.cartService.addToCart(food);
     this.router.navigateByUrl('/cart');
    } else {
      this.router.navigateByUrl('/login');
    }
    // this.cartService.addToCart(food);
    // this.router.navigateByUrl('/cart');
  }
}


