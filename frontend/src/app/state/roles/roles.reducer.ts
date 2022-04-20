import { createReducer, on } from '@ngrx/store';
import { Rol } from 'src/app/models/Rol.model';
import * as rolesActions from './roles.actions';

export interface State {
  items: Rol[];
}

export const initialState: State = {
  items: [],
}

export const rolesReducer = createReducer(
  initialState,

  on(rolesActions.loadRolesSuccess, (state, { roles }) => {
    return ({ ...state, items: roles })
  }),

)
