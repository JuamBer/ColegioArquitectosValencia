import { createReducer, on } from '@ngrx/store';
import { Evento } from 'src/app/models/Evento.model';
import { JwtDTO } from 'src/app/models/JwtDTO.mode';
import { Message } from 'src/app/models/Message.model';
import * as eventosActions from './eventos.actions';
import * as messages from 'src/app/utils/messages';
export interface State {
  items: Evento[];
  message: Message | null
}

export const initialState: State = {
  items: [],
  message: null
}

export const eventosReducer = createReducer(
  initialState,
  on(eventosActions.loadEventos, (state) => {
    return ({ ...state, message: messages.loadingMessage })
  }),
  on(eventosActions.loadEventosSuccess, (state, { eventos }) => {
    return ({ ...state, items: eventos, message: messages.loadEventosSucess})
  }),
  on(eventosActions.loadEventosFail, (state, { error }) => {
    return ({ ...state, message: messages.errorMessage})
  }),

  on(eventosActions.createEvento, (state) => {
    return ({ ...state, message: messages.loadingMessage })
  }),

  on(eventosActions.createEventoSuccess, (state, { evento }) => {
    return ({ ...state, items: [...state.items, evento], message: messages.createEventoSuccess })
  }),

  on(eventosActions.deleteEvento, (state, { id }) => {
    return ({ ...state, message: messages.loadingMessage })
  }),
  on(eventosActions.deleteEventoSuccess, (state, { id }) => {
    console.log(state.items.filter(evento => evento.id != id));

    return ({ ...state, message: messages.deleteEventosSucess, items: state.items.filter(evento => evento.id != id) })
  }),

  on(eventosActions.updateEvento, (state, { evento }) => {
    return ({ ...state, message: messages.loadingMessage })
  }),
  on(eventosActions.updateEventoSuccess, (state, { evento }) => {
    return ({
      ...state, message: messages.updateEventoSuccess, items: state.items.map(item => {
        if (item.id == evento.id) {
          return evento
        } else {
          return item
        }
      })
    })
  }),
  on(eventosActions.updateEventoFail, (state, { error }) => {
    return ({ ...state, error: error, message: messages.errorMessage })
  }),
  on(eventosActions.orderBy, (state, { column }) => {
    let eventos = { ...state.items }

    return {
      ...state,
      items: {...eventos}
    }
  })
);

