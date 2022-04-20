import { Injectable } from '@angular/core';
import { Actions, createEffect, ofType } from '@ngrx/effects';
import { EMPTY, EmptyError } from 'rxjs';
import { map, mergeMap, catchError, concatMap } from 'rxjs/operators';
import { RolService } from 'src/app/services/rol.service';
import * as rolesActions from './roles.actions';

@Injectable()
export class RolesEffects {

  loadRoles$ = createEffect(() => this.actions$.pipe(
    ofType(rolesActions.loadRoles),
    mergeMap(() => this.rolesService.getRoles()
      .pipe(
        map(roles => ({ type: '[Roles] Load Roles Success', roles: roles })),
        catchError(() => EMPTY)
      )
    )
  ));


  constructor(
    private actions$: Actions,
    private rolesService: RolService
  ) { }
}
