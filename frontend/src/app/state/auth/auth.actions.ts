import { createAction, props } from '@ngrx/store';
import { JwtDTO } from 'src/app/models/JwtDTO.mode';
import { LoginUsuarioDTO } from 'src/app/models/LoginUsuarioDTO.model';
import { Permiso } from 'src/app/models/Permiso.model';
import { Usuario } from 'src/app/models/Usuario.model'

export const login = createAction(
  '[Auth] Login',
  props<{ loginUsuarioDTO: LoginUsuarioDTO }>()
);

export const setUser = createAction(
  '[Auth] setUser',
  props<{ usuario: JwtDTO}>()
);

export const unSetUser = createAction(
  '[Auth] unSetUser'
);
