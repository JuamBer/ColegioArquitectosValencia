import { Component, OnInit } from '@angular/core';
import { Router, NavigationEnd } from '@angular/router';
import { Permiso } from '../../models/Permiso.model';
import { Usuario } from '../../models/Usuario.model';
import { AuthService } from '../../services/auth.service';

//NGRX
import { AppState } from '../../state/app.reducer';
import { Store } from '@ngrx/store';
import * as uiActions from 'src/app/state/ui/ui.actions';
import { JwtDTO } from '../../models/JwtDTO.mode';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.scss']
})
export class SidebarComponent implements OnInit {
  permisos: any[] = [];
  page: string = "";
  usuario: JwtDTO = {
    id: 0,
    token: '',
    nombre: '',
    authorities: []
  };
  currentRoute: string = "/ dashboard";

  constructor(
    private authService: AuthService,
    private router: Router,
    private store: Store<AppState>
  ) {
  }

  ngOnInit(): void {
    this.store.select("usuario").subscribe(
      (usuario: any)=>{
        this.usuario = usuario.usuario;
        this.permisos = usuario.usuario?.authorities;
      }
    )
    this.store.select("ui").subscribe(
      (ui: any) => {
        this.page = ui.page;
      }
    )
  }

  goTo(route: string){
    this.store.dispatch(uiActions.goTo({ page: route }));
    this.router.navigate([`/${route}`]);
    //this.currentRoute = this.router.url;
  }
  logOut() {
    this.authService.logOut();
  }

  tienePermiso(nombre: string): boolean {
    return this.permisos.some((permiso) => permiso.authority == nombre)
  }
}
