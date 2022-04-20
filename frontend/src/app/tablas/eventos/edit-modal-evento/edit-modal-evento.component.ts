import { Component, Inject, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { ThemePalette } from '@angular/material/core';
import { Rol } from '../../../models/Rol.model';
//NGRX
import { AppState } from '../../../state/app.reducer';
import { Store } from '@ngrx/store';
import * as eventoActions from 'src/app/state/eventos/eventos.actions';

import { Observable } from 'rxjs';
import { Evento } from '../../../models/Evento.model';
import { Permiso } from '../../../models/Permiso.model';
import { Usuario } from '../../../models/Usuario.model';
import { JwtDTO } from '../../../models/JwtDTO.mode';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { ThisReceiver } from '@angular/compiler';
import { EventosComponent } from '../eventos/eventos.component';

export interface Task {
  name: string;
  completed: boolean;
  color: ThemePalette;
  subtasks?: Task[];
}

@Component({
  selector: 'app-edit-modal-evento',
  templateUrl: './edit-modal-evento.component.html',
  styleUrls: ['./edit-modal-evento.component.scss']
})
export class EditModalEventoComponent implements OnInit {

  evento: any = this.data.evento;

  form: FormGroup = this.formBuilder.group({
    id: [this.evento.id,],
    nombre: [this.evento.nombre,],
    fecha: [this.evento.fecha,],
    descripcion: [this.evento.descripcion,],
    web: [this.evento.web,],
  })


  constructor(
    private store: Store<AppState>,
    public dialogRef: MatDialogRef<EventosComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
    private formBuilder: FormBuilder
  ) { }

  ngOnInit(): void {}

  send(evento: any) {
    console.log(evento);
    this.store.dispatch(eventoActions.updateEvento({ evento: evento}));
    this.onClose();
  }




  onClose(): void {
    this.dialogRef.close();
  }


}
