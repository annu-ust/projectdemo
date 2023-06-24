import { Component } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from 'src/app/model/User';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent {
  user:User=new User();
  signupForm!: FormGroup;
  constructor(private router: Router,private service:UserService,private formBuilder: FormBuilder) { 
    this.signupForm = this.formBuilder.group({
      username: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      password: ['', Validators.required],
      phoneNumber: ['', Validators.required]
    });
  }
  ngOnInit() {
    this.signupForm = this.formBuilder.group({
      username: ['', Validators.required],
      email: ['',  Validators.pattern("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$")],
      password: ['', Validators.pattern("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$")],
      phoneNumber: ['', Validators.pattern("^[0-9]{3}-[0-9]{3}-[0-9]{4}")]
    });
  }
get f() {
  return this.signupForm.controls;
}

  signUp(): any {
    this.signupForm.markAllAsTouched();

    if (this.signupForm.invalid) {
      alert('Please fill  all the fields.');
      return;
    }
    this.service.saveUser(this.user).subscribe((data)=>{
      this.user = new User();
      this.router.navigate(['/login']);
    });
  }
  
 

  
  
  
}
