import { createReducer, on } from '@ngrx/store';
import { Permiso } from 'src/app/models/Permiso.model';
import * as permisosActions from './permisos.actions';

export interface State {
  items: Permiso[];
}

export const initialState: State = {
  items: [],
}

export const permisosReducer = createReducer(
  initialState,

  on(permisosActions.loadPermisosSuccess, (state, { permisos }) => {
    return ({ ...state, items: permisos })
  }),

)
