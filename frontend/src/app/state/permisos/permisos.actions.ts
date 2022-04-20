import { createAction, props } from '@ngrx/store';
import { Permiso } from 'src/app/models/Permiso.model';

export const loadPermisos = createAction(
  '[Permisos] Load Permisos'
);
export const loadPermisosSuccess = createAction(
  '[Permisos] Load Permisos Success',
  props<{ permisos: Permiso[] }>()
);
