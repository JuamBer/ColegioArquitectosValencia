import { Injectable } from '@angular/core';
import { Actions, createEffect, ofType } from '@ngrx/effects';
import { EMPTY, EmptyError } from 'rxjs';
import { map, mergeMap, catchError, concatMap } from 'rxjs/operators';
import { Evento } from 'src/app/models/Evento.model';
import { EventoService } from '../../services/evento.service';
import * as eventosActions from './eventos.actions';
import { of } from 'rxjs';

@Injectable()
export class EventosEffects {

  loadEventos$ = createEffect(() => this.actions$.pipe(
    ofType(eventosActions.loadEventos),
    mergeMap(() => this.eventosService.getEventos()
      .pipe(
        map(eventos => ({ type: '[Eventos] Load Eventos Success', eventos: eventos })),
        catchError(err => of(eventosActions.loadEventosFail({ error: err })))
      )
    )
  ));


  createEvento$ = createEffect(() =>
    this.actions$.pipe(
      ofType(eventosActions.createEvento),
      mergeMap((evento) =>
        this.eventosService.create(evento.evento).pipe(
          map((evento: Evento) => eventosActions.createEventoSuccess({ evento: evento })),
          catchError(err => EMPTY)
        )
      )
    )
  );

  deleteEvento$ = createEffect(() =>
    this.actions$.pipe(
      ofType(eventosActions.deleteEvento),
      mergeMap((evento) => {
        console.log(evento);

          return this.eventosService.delete(evento.id).pipe(
            map(() => {
              console.log("map");

              return eventosActions.deleteEventoSuccess({ id: evento.id })
            })
          )
        }
      )
    )
  );

  updateEvento$ = createEffect(() => this.actions$.pipe(
    ofType(eventosActions.updateEvento),
    mergeMap((action) => this.eventosService.updateEvento(action.evento)
      .pipe(
        map(() => eventosActions.updateEventoSuccess({ evento: action.evento })),
        catchError(() => EMPTY)
      )
    )
  ));


  constructor(
    private actions$: Actions,
    private eventosService: EventoService
  ) { }
}
