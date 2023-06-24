import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import jwt_decode from 'jwt-decode';

@Injectable({
  providedIn: 'root'
})
export class AuthserviceService {
/*
  private isAuthenticated = false;
  private authToken!: string ;

  constructor(private http: HttpClient,private router: Router) { }

  login(email: string, password: string) {
    // Send an HTTP request to authenticate the user
    // Replace 'api/login' with your authentication endpoint
    this.http.post('http://localhost:8080/user/login', { email, password }).subscribe(
      (response: any) => {
        // Authentication successful
        this.isAuthenticated = true;
        this.authToken = response.token;
        // Store the authentication token or necessary data in localStorage or a secure storage mechanism
        //localStorage.setItem('authToken', this.authToken);
        // Store the authentication token and role in localStorage
      localStorage.setItem('authToken', this.authToken);
      localStorage.setItem('userRole', response.role);
        // Redirect to the desired page
        // Replace '/home' with the route you want to navigate to after successful login
        //this.router.navigate(['/']);
      },
      (error: any) => {
        // Authentication failed
        console.error(error);
        // Display error message or handle the error
      }
    );
  }

  logout() {
    // Clear authentication data and navigate to the login page
    this.isAuthenticated = false;
    this.authToken = '';
    localStorage.removeItem('authToken');
    this.router.navigate(['/login']);
  }

  isAuthenticatedUser() {
    // Check if the user is authenticated
    return this.isAuthenticated;
  }

  getAuthToken() {
    // Get the authentication token
    return this.authToken;
  }
}
*/
// ...
private isAuthenticated = false;
  private authToken!: string ;
  errorMessage: string = '';
  unregisteredMessage: string = '';
  constructor(private http: HttpClient,private router: Router) { }
  
login(email: string, password: string) {
  this.http.post('http://localhost:8080/user/login', { email, password }).subscribe(
    (response: any) => {
      
      // Check if token exist in the response
      if (response.token ) {
        // Authentication successful
        this.isAuthenticated = true;
        this.authToken = response.token;
        
        // localStorage.setItem('authToken', this.authToken);
        // localStorage.setItem('userRole', this.userRole);
      // this.isAuthenticated = true;
      // this.authToken = response.token;
      
      // Decode the token to retrieve the user role
      const decodedToken: any = jwt_decode(this.authToken);
      const userRole = decodedToken.role;
      
      // Store the authentication token and user role in localStorage
      localStorage.setItem('authToken', this.authToken);
      localStorage.setItem('userRole', userRole);
      
      // Redirect to the desired page
      if (userRole === 'admin') {
        this.router.navigate(['/create']);
      } else {
        this.router.navigate(['/']);
      }}
      else {
        // Invalid token or role, show alert message or handle the case
        alert('Invalid token or role. Please try again.');
      }
    },
    (error: any) => {
      // Authentication failed
      console.error(error);
      // Display error message or handle the error
      
      if (error.status === 400) {
        this.unregisteredMessage = 'User not found. Please sign up to create an account.';
        alert(this.unregisteredMessage);
        
      } else {
        this.errorMessage = 'Invalid username or password. Please try again.';
        alert(this.errorMessage);
      }
    }
  );
}

isAuthenticatedUser() {
  // Check if the user is authenticated
  //console.log(this.isAuthenticated);
  return this.isAuthenticated;
  
}
setAuthenticated(status: boolean): void {
  this.isAuthenticated = status;
}

logout() {
  // Clear authentication data and navigate to the login page
  this.isAuthenticated = false;
  this.authToken = '';
  localStorage.removeItem('authToken');
  this.router.navigate(['/login']);
}
}
