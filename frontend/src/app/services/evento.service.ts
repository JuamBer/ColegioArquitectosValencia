import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Evento } from '../models/Evento.model';

@Injectable({
  providedIn: 'root'
})
export class EventoService {

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

  create(evento: Evento): Observable<Evento> {
    this.getHeaders();
    return this.http.post<Evento>(`${this.API_URL}/eventos/nuevo`, evento, { headers: this.headers });
  }

  delete(id: number) {
    this.getHeaders();
    return this.http.delete(`${this.API_URL}/eventos/delete/${id}`, { headers: this.headers });
  }
  updateEvento(evento: Evento) {
    this.getHeaders();
    return this.http.put(`${this.API_URL}/eventos/update`, evento, { headers: this.headers });

  }

  getEventos(){
    this.getHeaders();
    return this.http.get(`${this.API_URL}/eventos/lista`, { headers: this.headers });
  }
}
