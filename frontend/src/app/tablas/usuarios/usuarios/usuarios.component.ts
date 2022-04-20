import { IfStmt } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Permiso } from '../../../models/Permiso.model';
import { AuthService } from '../../../services/auth.service';
import { EventoService } from '../../../services/evento.service';
import { MatDialog } from '@angular/material/dialog';

//NGRX
import { AppState } from '../../../state/app.reducer';
import { Store } from '@ngrx/store';
import * as usuariosActions from 'src/app/state/usuarios/usuarios.actions';
import { Observable } from 'rxjs';
import { Usuario } from '../../../models/Usuario.model';
import { EditModalUserComponent } from '../edit-modal-user/edit-modal-user.component';
import { JwtDTO } from '../../../models/JwtDTO.mode';

@Component({
  selector: 'app-usuarios',
  templateUrl: './usuarios.component.html',
  styleUrls: ['./usuarios.component.scss']
})
export class UsuariosComponent implements OnInit {
  ALGO: any[] = [{nombre:"z"},{nombre:"a"},{nombre:"b"}]
  permisos: any[] = [];
  usuarioLoggeado: JwtDTO = {
    id: 0,
    token: '',
    nombre: '',
    authorities: []
  };
  usuarios: Usuario[] = [];
  orderByColumn: string = "id";

  constructor(
    private store: Store<AppState>,
    private dialog: MatDialog
  ) { }

  ngOnInit(): void {
    this.store.dispatch(usuariosActions.loadUsuarios());
    this.store.select("usuario").subscribe(
      (usuario: any) => {
        this.usuarioLoggeado = usuario.usuario;
        this.permisos = usuario.usuario?.authorities;
      }
    )
    this.store.select(state => state.usuarios.items).subscribe(usuarios=>{
      this.usuarios = usuarios;
    })
  }



  tienePermiso(nombre: string): boolean {
    return this.permisos.some((permiso) => permiso.authority == nombre)
  }

  deleteUser(id: any) {
    console.log(id);
    this.store.dispatch(usuariosActions.deleteUsuario({id:id}))
  }

  updateUser(user: Usuario) {
    const dialogRef = this.dialog.open(EditModalUserComponent,{
        data: {
          usuario: user
        }
      }
    );
  }

  orderBy(column: string){
    this.store.dispatch(usuariosActions.orderBy({ column: column}));
  }




}
