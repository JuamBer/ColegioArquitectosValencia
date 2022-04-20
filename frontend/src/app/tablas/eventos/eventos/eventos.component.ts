import { IfStmt } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Permiso } from '../../../models/Permiso.model';
import { AuthService } from '../../../services/auth.service';
import { EventoService } from '../../../services/evento.service';

//NGRX
import { AppState } from '../../../state/app.reducer';
import { Store } from '@ngrx/store';
import * as eventosActions from 'src/app/state/eventos/eventos.actions';
import { Observable } from 'rxjs';
import { Evento } from '../../../models/Evento.model';
import { MatDialog } from '@angular/material/dialog';
import { EditModalEventoComponent } from '../edit-modal-evento/edit-modal-evento.component';
import * as compare from 'src/app/utils/compareFunctions';


@Component({
  selector: 'app-eventos',
  templateUrl: './eventos.component.html',
  styleUrls: ['./eventos.component.scss']
})
export class EventosComponent implements OnInit {
  permisos: any[] = [];
  eventos: Evento[] = [];
  form: FormGroup = this.formBuilder.group({
    nombre: ['', Validators.required],
    fecha: ['', Validators.required],
    descripcion: ['', Validators.required],
    web: ['', Validators.required]
  })

  constructor(
    private formBuilder:FormBuilder,
    private store: Store<AppState>,
    private dialog: MatDialog
  ) { }

  ngOnInit(): void {
    this.store.dispatch(eventosActions.loadEventos());
    this.store.select(state => state.eventos.items).subscribe(
      eventos => this.eventos=eventos
    )
    this.store.select("usuario").subscribe((stateUsuario) => {
      if (stateUsuario.usuario?.authorities){
        this.permisos = stateUsuario.usuario?.authorities;
      }
    })
  }

  tienePermiso(nombre: string): boolean {
    return this.permisos.some((permiso) => permiso.authority == nombre)
  }

  insertEvent(formValue: any) {
    this.store.dispatch(eventosActions.createEvento({ evento: formValue}))
  }

  deleteEvent(id: any) {
    this.store.dispatch(eventosActions.deleteEvento({ id: id }))
  }

  updateEvent(evento: Evento) {
    const dialogRef = this.dialog.open(EditModalEventoComponent, {
      data: {
        evento: evento
      }
    }
    );
  }


  orderBy(column: string) {
    let eventosreplica = [...this.eventos];


    switch (column) {
      case "id":
        eventosreplica.sort(compare.compareId); break;
      case "nombre":
        eventosreplica.sort(compare.compareNombre);break;
      case "web":
        eventosreplica.sort(compare.compareWeb); break;
      case "descripcion":
        eventosreplica.sort(compare.compareDescripcion); break;
      case "fecha":
        eventosreplica.sort(compare.compareFecha); break;
    }
    this.eventos = [...eventosreplica]
  }




}
