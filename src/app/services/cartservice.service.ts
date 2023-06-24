import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { CartItem } from '../model/cartitem';

@Injectable({
  providedIn: 'root'
})

export class CartserviceService {
  // cartItems: any[] = [];

  // constructor() {
  //   this.cartItems = [];
  // }

  // addToCart(item: any) {
  //   const existingItem = this.cartItems.find((cartItem) => cartItem.foodId === item.foodId);

  //   if (existingItem) {
  //     existingItem.quantity++;
  //   } else {
  //     const newItem = { ...item, quantity: 1 };
  //     this.cartItems.push(newItem);
  //   }
  // }

  // getCartItems() {
  //   return this.cartItems;
  // }
  // removeCartItem(index: number) {
  //   this.cartItems.splice(index, 1);
  // }
  
  // incrementQuantity(item: any) {
  //   item.quantity++;
  // }

  // decrementQuantity(item: any) {
  //   if (item.quantity > 1) {
  //     item.quantity--;
  //   }
  // }

  // calculateTotalAmount() {
  //   let total = 0;
  //   for (const item of this.cartItems) {
  //     total += item.foodPrice * item.quantity;
  //   }
  //   return total;
  // }
 
  cartItems: CartItem[] = [];

  addToCart(food: any): void {
    const existingItem = this.cartItems.find(item => item.foodName === food.foodName);

    if (existingItem) {
      existingItem.quantity++;
    } else {
      const newItem: CartItem = {
        foodImg: food.foodImg,
        foodName: food.foodName,
        foodPrice: food.foodPrice,
        quantity: 1,
        item: undefined
      };
      this.cartItems.push(newItem);
    }
  }

  getCartItems(): CartItem[] {
    return this.cartItems;
  }

  removeCartItem(index: number): void {
    this.cartItems.splice(index, 1);
  }
  
  incrementQuantity(item: CartItem): void {
    item.quantity++;
  }

  decrementQuantity(item: CartItem): void {
    if (item.quantity > 1) {
      item.quantity--;
    }
  }

  calculateTotalAmount(): number {
    return this.cartItems.reduce((total, item) => total + (item.foodPrice * item.quantity), 0);
  }
}