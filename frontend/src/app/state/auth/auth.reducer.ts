import { createReducer, on } from '@ngrx/store';
import { JwtDTO } from 'src/app/models/JwtDTO.mode';
import { Permiso } from 'src/app/models/Permiso.model';
import { Usuario } from 'src/app/models/Usuario.model'
import * as authActions from './auth.actions';

export interface State {
  usuario: JwtDTO | null;
}

export const initialState: State = {
  usuario: null
}

export const authReducer = createReducer(initialState,
  on(authActions.setUser, (state, { usuario }) => ({ ...state, usuario: usuario})),
  on(authActions.unSetUser, (state) => ({ ...state, usuario: null })),
);
