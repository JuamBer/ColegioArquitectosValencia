import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Rol } from '../models/Rol.model';

@Injectable({
  providedIn: 'root'
})
export class RolService {

  private API_URL: string = "http://localhost:8080"
  private headers: HttpHeaders = new HttpHeaders();

  constructor(
    private http: HttpClient
  ) {

  }

  getHeaders(){
    const userToken = localStorage.getItem("user-token");
    if (userToken) {
      this.headers = new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': `Bearer ${JSON.parse(userToken)}`
      })
    }
  }

  create(rol: Rol): Observable<Rol> {
    this.getHeaders();
    return this.http.post<Rol>(`${this.API_URL}/roles/nuevo`, rol, { headers: this.headers });
  }

  delete(id: number) {
    this.getHeaders();
    return this.http.delete(`${this.API_URL}/roles/delete/${id}`, { headers: this.headers });
  }

  getRoles(){
    this.getHeaders();
    return this.http.get(`${this.API_URL}/roles/lista`, { headers: this.headers });
  }
}
