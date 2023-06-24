
import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { CartItem } from 'src/app/model/cartitem';
import { CartserviceService } from 'src/app/services/cartservice.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent {
  cartItems: CartItem[];

  constructor(private cartService: CartserviceService,private router:Router) {
    this.cartItems = this.cartService.getCartItems();
  }

  removeFromCart(index: number): void {
    this.cartService.removeCartItem(index);
    this.cartItems = this.cartService.getCartItems();
  }

  incrementQuantity(item: CartItem): void {
    this.cartService.incrementQuantity(item);
  }

  decrementQuantity(item: CartItem): void {
    this.cartService.decrementQuantity(item);
  }

  calculateTotalAmount(): number {
    return this.cartService.calculateTotalAmount();
  }
  goBack(): void {
    this.router.navigate(['/menu']); 
}
pay(): void {
  this.router.navigate(['/payment'])
}
}