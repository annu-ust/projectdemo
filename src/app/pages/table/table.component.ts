import { Component } from '@angular/core';
import { FormBuilder, FormGroup, NgForm, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { TableserviceService } from 'src/app/services/tableservice.service';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent {
  reservationForm!: FormGroup;

  constructor(private reservationService:TableserviceService,private formBuilder: FormBuilder,private router:Router){}

  ngOnInit(): void {
    this.reservationForm = this.formBuilder.group({
      name: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      phoneNumber: ['', Validators.required],
      dateTime: ['', Validators.required],
      numberOfPeople: ['', Validators.required],
      specialRequests: ''
    });
  }

  // onSubmit(): void {
  //   if (this.reservationForm.valid) {
  //     // Perform actions with the reservation data
  //     // console.log(this.reservationForm.value);
  //   }
  // }
  onSubmit(): void {
    if (this.reservationForm.valid) {
      // Perform actions with the reservation data
      console.log(this.reservationForm.value);
      console.log("sasi");
      // Example: Call a service method to save the reservation data
      this.reservationService.createReservation(this.reservationForm.value)
        .subscribe(
          response => {
            // Handle the success response
            console.log('Reservation saved successfully:', response);
            alert('Reservation saved successfully');
            // Reset the form after successful submission
            this.reservationForm.reset();
            //route to home page
            this.gotoHomePage();
          },
          error => {
            // Handle the error response
            console.error('Failed to save reservation:', error);
          }
        );
    }
  }
  gotoHomePage() {
    this.router.navigate(['/home']);
  }
  
  
}
