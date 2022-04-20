import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { LoginUsuarioDTO } from '../models/LoginUsuarioDTO.model';
import { ChangePasswordDTO } from '../models/ChangePasswordDTO.model';
import { RegistroUsuarioDTO } from '../models/RegistroUsuarioDTO.model';
import { BehaviorSubject, map, Observable } from 'rxjs';
import { Usuario } from '../models/Usuario.model';
import { Permiso } from '../models/Permiso.model';

//NGRX
import { AppState } from '../state/app.reducer';
import { Store } from '@ngrx/store';
import * as authActions from 'src/app/state/auth/auth.actions';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private API_URL: string = "http://localhost:8080"
  private headers: HttpHeaders = new HttpHeaders();

  constructor(
    private http: HttpClient,
    private router: Router,
    private authStore: Store<AppState>
  ) {
    const userToken = localStorage.getItem('user-token');
    if (userToken){
      this.headers = new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': `Bearer ${JSON.parse(userToken)}`
      })
    }
  }



  login(loginUsuarioDTO: LoginUsuarioDTO){
    return this.http.post<any>(`${this.API_URL}/auth/login`, loginUsuarioDTO).pipe(
      map(response => {
        localStorage.setItem('user-token', JSON.stringify(response.token));
        console.log(response);

        this.authStore.dispatch(authActions.setUser({usuario: response}));
        return response;
      })
    );
  }

  register(registroUsuarioDTO: RegistroUsuarioDTO) {
    return this.http.post(`${this.API_URL}/auth/register`, registroUsuarioDTO);
  }

  sendEmail(email: string) {
    const params = new HttpParams().set("email", email);
    return this.http.post(`${this.API_URL}/change-password/send-email`, params);
  }

  changePassword(changePasswordDTO: ChangePasswordDTO) {
    return this.http.post(
      `${this.API_URL}/change-password/change-password`,
      { ...changePasswordDTO});
  }

  tienePermiso(id_user: number, permiso: Permiso): Observable<Permiso[]> {
    return this.http.post<any>(`${this.API_URL}/usuarios/tiene-permiso/${id_user}`, permiso);
  }

  getPermisos(id: string): Observable<Permiso[]> {
    return this.http.get<any>(`${this.API_URL}/usuarios/permisos/${id}`, { headers: this.headers});
  }


  logOut() {
    localStorage.removeItem('user-token');
    this.router.navigate(['/login'])
  }

}
