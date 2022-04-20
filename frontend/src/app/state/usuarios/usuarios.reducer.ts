import { createReducer, on } from '@ngrx/store';
import { Message } from 'src/app/models/Message.model';
import { Usuario } from 'src/app/models/Usuario.model';
import * as usuariosActions from './usuarios.actions';
import * as messages from 'src/app/utils/messages';

export interface State {
  items: Usuario[];
  message: Message | null
}

export const initialState: State = {
  items: [],
  message: null
}

export const usuariosReducer = createReducer(
  initialState,
  on(usuariosActions.loadUsuarios, (state) => {
    return ({ ...state, message: messages.loadingMessage })
  }),
  on(usuariosActions.loadUsuariosSuccess, (state, { usuarios }) => {
    return ({ ...state, items: usuarios, message: messages.loadUsuariosSuccess })
  }),
  on(usuariosActions.deleteUsuario, (state, { id }) => {
    return ({ ...state, message: messages.loadingMessage})
  }),
  on(usuariosActions.deleteUsuarioSuccess, (state, { id }) => {
    console.log(id);
    console.log(state.items);

    return {
      ...state,
      message: messages.deleteUsuarioSucess,
      items: state.items.filter(usuario => usuario.id != id)
    }
  }),


  on(usuariosActions.updateUsuario, (state, { usuario }) => {
    return ({ ...state, message: messages.loadingMessage })
  }),
  on(usuariosActions.updateUsuarioSuccess, (state, { usuario }) => {
    return ({
      ...state, message: messages.updateUsuarioSuccess, items: state.items.map(item => {
      if (item.id == usuario.id){
        return usuario
      }else{
        return item
      }
    }) })
  }),
  on(usuariosActions.updateUsuarioFail, (state, { error }) => {
    return ({ ...state, error: error, message: messages.errorMessage })
  }),
  on(usuariosActions.orderBy, (state, { column }) => {
    let usuarios = {...state.items.slice()}
    return {
      ...state,
    }
  })
);
