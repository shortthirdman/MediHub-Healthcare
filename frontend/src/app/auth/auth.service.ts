import { Injectable, inject } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

const AUTH_API = 'http://localhost:8080/api/auth/';
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private http: HttpClient = inject(HttpClient);
  
  constructor() {
  }

  getAccessToken(): void {
    this.http.post('', {}).pipe();
  }

  login(username: string, password: string): Observable<any> {
    return this.http.post(AUTH_API + 'login', {}, httpOptions)
  }
}
