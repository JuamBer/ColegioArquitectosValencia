import { createAction, props } from '@ngrx/store';
import { Rol } from 'src/app/models/Rol.model';

export const loadRoles = createAction(
  '[Roles] Load Roles'
);
export const loadRolesSuccess = createAction(
  '[Roles] Load Roles Success',
  props<{ roles: Rol[] }>()
);


export const deleteRol = createAction(
  '[Roles] deleteRol',
  props<{ id: number }>()
);
export const deleteRolSuccess = createAction(
  '[Roles] deleteRol Success',
  props<{ id: number }>()
);
export const deleteRolFail = createAction(
  '[Roles] deleteRol Fail'
);
