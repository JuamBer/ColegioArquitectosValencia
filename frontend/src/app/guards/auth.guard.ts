import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';

//NGRX
import { AppState } from '../state/app.reducer';
import { Store } from '@ngrx/store';
import * as authActions from 'src/app/state/auth/auth.actions';
import { JwtDTO } from '../models/JwtDTO.mode';
import { map, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {

  constructor(
    private router: Router,
    private authStore: Store<AppState>
  ){

  }
  canActivate(): Observable<boolean> {
    return this.authStore.select("usuario").pipe(
      map(usuario=>{
        if (usuario.usuario != null){
          return true
        }
        this.router.navigate(['/login'])
        return false
      }))
  }

}


