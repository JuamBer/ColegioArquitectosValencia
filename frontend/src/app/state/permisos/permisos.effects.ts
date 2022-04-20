import { Injectable } from '@angular/core';
import { Actions, createEffect, ofType } from '@ngrx/effects';
import { EMPTY, EmptyError } from 'rxjs';
import { map, mergeMap, catchError, concatMap } from 'rxjs/operators';
import { PermisoService } from 'src/app/services/permiso.service';
import * as permisosActions from './permisos.actions';

@Injectable()
export class PermisosEffects {

  loadPermisos$ = createEffect(() => this.actions$.pipe(
    ofType(permisosActions.loadPermisos),
    mergeMap(() => this.permisoService.getPermisos()
      .pipe(
        map(permisos => ({ type: '[Permisos] Load Permisos Success', permisos: permisos })),
        catchError(() => EMPTY)
      )
    )
  ));


  constructor(
    private actions$: Actions,
    private permisoService: PermisoService
  ) { }
}
