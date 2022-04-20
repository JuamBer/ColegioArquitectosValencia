import { createAction, props } from '@ngrx/store';
import { Usuario } from 'src/app/models/Usuario.model';

export const loadUsuarios = createAction(
  '[Usuarios] Load Usuarios'
);
export const loadUsuariosSuccess = createAction(
  '[Usuarios] Load Usuarios Success',
  props<{ usuarios: Usuario[] }>()
);


export const deleteUsuario = createAction(
  '[Usuarios] deleteUsuario',
  props<{ id: number }>()
);
export const deleteUsuarioSuccess = createAction(
  '[Usuarios] deleteUsuario Success',
  props<{ id: number }>()
);
export const deleteUsuarioFail = createAction(
  '[Usuarios] deleteUsuario Fail'
);


export const updateUsuario = createAction(
  '[Usuarios] updateUsuario',
  props<{ usuario: Usuario }>()
);
export const updateUsuarioSuccess = createAction(
  '[Usuarios] updateUsuarioSuccess',
  props<{ usuario: Usuario }>()
);
export const updateUsuarioFail = createAction(
  '[Usuarios] updateUsuarioFail',
  props<{ error: any }>()
);


export const orderBy = createAction(
  '[Usuarios] orderBy',
  props<{ column: string }>()
);
