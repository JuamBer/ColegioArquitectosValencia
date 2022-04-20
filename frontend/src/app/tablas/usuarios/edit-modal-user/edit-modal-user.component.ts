import { Component, Inject, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { ThemePalette } from '@angular/material/core';
import { Rol } from '../../../models/Rol.model';
//NGRX
import { AppState } from '../../../state/app.reducer';
import { Store } from '@ngrx/store';
import * as usuariosActions from 'src/app/state/usuarios/usuarios.actions';
import * as rolesActions from 'src/app/state/roles/roles.actions';
import * as permisosActions from 'src/app/state/permisos/permisos.actions';

import { Observable } from 'rxjs';
import { Evento } from '../../../models/Evento.model';
import { Permiso } from '../../../models/Permiso.model';
import { Usuario } from '../../../models/Usuario.model';
import { JwtDTO } from '../../../models/JwtDTO.mode';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { ThisReceiver } from '@angular/compiler';
import { UsuariosComponent } from '../usuarios/usuarios.component';

export interface Task {
  name: string;
  completed: boolean;
  color: ThemePalette;
  subtasks?: Task[];
}

@Component({
  selector: 'app-edit-modal-user',
  templateUrl: './edit-modal-user.component.html',
  styleUrls: ['./edit-modal-user.component.scss']
})
export class EditModalUserComponent implements OnInit {

  user: any = this.data.usuario;
  roles: Rol[] = [];
  permisos: Permiso[] = [];
  mispermisos: Permiso[] = this.user.permisos;
  permisosArray = new FormArray([]);
  form: FormGroup = this.formBuilder.group({
    id: [this.user.id,],
    nombre: [this.user.nombre,],
    email: [this.user.email,],
    rol: [this.user.rol,],
    permisos: this.permisosArray
  })


  constructor(
    private store: Store<AppState>,
    public dialogRef: MatDialogRef<UsuariosComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
    private formBuilder: FormBuilder
  ) { }

  ngOnInit(): void {
    this.user.permisos.forEach((permiso: any) => {
      this.permisosArray.push(new FormControl(permiso));
    })

    this.store.dispatch(rolesActions.loadRoles())
    this.store.dispatch(permisosActions.loadPermisos())

    this.store.select(state => state.roles.items).subscribe(
      (roles) => {
        this.roles = roles;
      }
    )
    this.store.select(state => state.permisos.items).subscribe(
      (permisos) => {
        this.permisos = permisos;
      }
    )
  }
  send(usuario: any) {
    console.log(usuario);
    this.store.dispatch(usuariosActions.updateUsuario({usuario: usuario}));
    this.onClose();
  }

  compareFunction(o1: any, o2: any) {
    return (o1.name == o2.name && o1.id == o2.id);
  }

  onRolChange(event: any){
    const checkArray: FormArray = this.form.get('permisos') as FormArray;

    event.value.permisos.forEach((permiso: any)=>{
      if (checkArray.controls.some(formcontrol => formcontrol.value.id == permiso.id)) {
      } else {
        this.permisosArray.push(new FormControl(permiso));
      }
    })
  }

  onPermisosChange(permiso: any) {
    const checkArray: FormArray = this.form.get('permisos') as FormArray;

    if (checkArray.controls.some(formcontrol => formcontrol.value.id == permiso.id)){
      const index = checkArray.controls.findIndex(formcontrol => formcontrol.value.id == permiso.id)
      this.permisosArray.removeAt(index);
    }else{
      this.permisosArray.push(new FormControl(permiso));
    }
  }

  onClose(): void {
    this.dialogRef.close();
  }


}
