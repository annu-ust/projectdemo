import { Component } from '@angular/core';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent {
  showSuccess!: boolean;

  showSuccessMessage() {
    this.showSuccess = true;
  }
  closeSuccessMessage() {
    this.showSuccess = false;
  }
  constructor() {
    // Constructor logic if needed
  }
}
