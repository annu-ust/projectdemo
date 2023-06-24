import { Component } from '@angular/core';

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})
export class ContactComponent {
  name!: string;
  email!: string;
  message!: string;

  sendMessage() {
    // Code to send the message goes here
    console.log('Message sent:', this.name, this.email, this.message);
    
    // Reset form fields
    this.name = '';
    this.email = '';
    this.message = '';
  }
}
