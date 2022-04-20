import { Injectable } from '@angular/core';
import { Actions, createEffect, ofType } from '@ngrx/effects';
import { EMPTY, EmptyError, of } from 'rxjs';
import { map, mergeMap, catchError, concatMap } from 'rxjs/operators';
import { UsuarioService } from 'src/app/services/usuario.service';
import * as usuariosActions from './usuarios.actions';

@Injectable()
export class UsuariosEffects {

  loadUsuarios$ = createEffect(() => this.actions$.pipe(
    ofType(usuariosActions.loadUsuarios),
    mergeMap(() => this.usuariosService.getUsuarios()
      .pipe(
        map(usuarios => ({ type: '[Usuarios] Load Usuarios Success', usuarios: usuarios })),
        catchError(() => EMPTY)
      )
    )
  ));

  deleteUsuario$ = createEffect(() =>
    this.actions$.pipe(
      ofType(usuariosActions.deleteUsuario),
      mergeMap((usuario) => {
        return this.usuariosService.delete(usuario.id).pipe(
          map((res: any) => {
            console.log(res);

            return usuariosActions.deleteUsuarioSuccess({ id: res.id })
          }),
          catchError(err => of(usuariosActions.deleteUsuarioFail()))
        )
      }
      )
    )
  );

  updateUsuario$ = createEffect(() => this.actions$.pipe(
    ofType(usuariosActions.updateUsuario),
    mergeMap((action) => this.usuariosService.updateUsuario(action.usuario)
      .pipe(
        map(() => usuariosActions.updateUsuarioSuccess({ usuario: action.usuario })),
        catchError(() => EMPTY)
      )
    )
  ));

  constructor(
    private actions$: Actions,
    private usuariosService: UsuarioService
  ) { }
}
