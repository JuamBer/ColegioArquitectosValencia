import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Permiso } from '../models/Permiso.model';
import { Usuario } from '../models/Usuario.model';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  private API_URL: string = "http://localhost:8080"
  private headers: HttpHeaders = new HttpHeaders();

  constructor(
    private http: HttpClient
  ) {}

  getHeaders() {
    const userToken = localStorage.getItem("user-token");
    if (userToken) {
      this.headers = new HttpHeaders({
        'Authorization': `Bearer ${JSON.parse(userToken)}`
      })
    }
  }

  create(evento: Usuario): Observable<Usuario> {
    console.log(evento);
    this.getHeaders();
    return this.http.post<Usuario>(`${this.API_URL}/usuarios/nuevo`, evento, { headers: this.headers });
  }

  delete(id: any) {
    this.getHeaders();
    return this.http.delete(`${this.API_URL}/usuarios/delete/${id}`, { headers: this.headers });
  }

  updateUsuario(usuario: Usuario) {
    this.getHeaders();
    return this.http.put(`${this.API_URL}/usuarios/update`, usuario, { headers: this.headers });
  }

  getUsuarios(){
    this.getHeaders();
    return this.http.get(`${this.API_URL}/usuarios/lista`, { headers: this.headers });
  }

  checkPermiso(permiso: Permiso, id_user: number) {
    this.getHeaders();
    return this.http.post(`${this.API_URL}/usuarios/checkPermiso/${id_user}`, permiso, { headers: this.headers }).toPromise();
  }

  checkRolPermiso(permiso: Permiso, id_user: number) {
    this.getHeaders();
    return this.http.post(`${this.API_URL}/usuarios/checkRolPermiso/${id_user}`, permiso, { headers: this.headers }).toPromise();
  }
}
