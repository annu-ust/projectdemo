import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../model/User';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }
  
  private authenticated: boolean = false;
   
  

  
  saveUser(user:User):Observable<Object>{
    return this.http.post("http://localhost:8080/user/signup",user);
  }
  fetchUser(user:User):Observable<Object>{
    this.authenticated = true;
    return this.http.post("http://localhost:8080/user/login",user);
    
  }

    

    // Set the authentication status of the user
     setAuthenticated(status: boolean): void {
      this.authenticated = status;
    }
  
    // Check if the user is authenticated
    isAuthenticated(): boolean {
      return this.authenticated;
    }
}
