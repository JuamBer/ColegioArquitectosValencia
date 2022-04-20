import { ActionReducerMap } from '@ngrx/store';
import * as ui from './ui/ui.reducer';
import * as auth from './auth/auth.reducer';
import * as eventos from './eventos/eventos.reducer';
import * as usuarios from './usuarios/usuarios.reducer';
import * as roles from './roles/roles.reducer';
import * as permisos from './permisos/permisos.reducer';


export interface AppState {
  ui: ui.State,
  usuario: auth.State,
  eventos: eventos.State,
  usuarios: usuarios.State,
  roles: roles.State,
  permisos: permisos.State
}



export const appReducers: ActionReducerMap<AppState> = {
  ui: ui.uiReducer,
  usuario: auth.authReducer,
  eventos: eventos.eventosReducer,
  usuarios: usuarios.usuariosReducer,
  roles: roles.rolesReducer,
  permisos: permisos.permisosReducer
}
