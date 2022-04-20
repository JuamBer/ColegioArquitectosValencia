import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';

@Injectable({
  providedIn: 'root'
})
export class LoggedGuard implements CanActivate {

  constructor(
    private authService: AuthService,
    private router: Router
  ) {

  }
  canActivate(): boolean {
    return true
  }

}
