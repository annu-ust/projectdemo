import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Reservation } from '../model/Reservation';

@Injectable({
  providedIn: 'root'
})
export class TableserviceService {
  // private baseUrl = 'http://localhost:8080/reservations';
  constructor(private http: HttpClient) { }

  createReservation(reservation: any): Observable<any> {
    return this.http.post('http://localhost:8080/reservation/submit', reservation);
  }
  showTableDetails():Observable<any[]>{
    return this.http.get<Reservation[]>('http://localhost:8080/reservation/getdetails');
  }
}
