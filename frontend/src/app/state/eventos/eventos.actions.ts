import { createAction, props } from '@ngrx/store';
import { Evento } from 'src/app/models/Evento.model';

export const loadEventos = createAction(
  '[Eventos] Load Eventos'
);
export const loadEventosSuccess = createAction(
  '[Eventos] Load Eventos Success',
  props<{ eventos: Evento[] }>()
);
export const loadEventosFail = createAction(
  '[Eventos] Load Eventos Fail',
  props<{ error: any }>()
);


export const createEvento = createAction(
  '[Eventos] create Evento',
  props<{ evento: Evento }>()
);
export const createEventoSuccess = createAction(
  '[Eventos] create Evento Success',
  props<{ evento: Evento}>()
);
export const createEventoFail = createAction(
  '[Eventos] create Evento Fail'
);


export const deleteEvento = createAction(
  '[Eventos] delete Evento',
  props<{ id: number }>()
);
export const deleteEventoSuccess = createAction(
  '[Eventos] delete Evento Success',
  props<{ id: number }>()
);
export const deleteEventoFail = createAction(
  '[Eventos] delete Evento Fail'
);

export const updateEvento = createAction(
  '[Eventos] updateEvento',
  props<{ evento: Evento }>()
);
export const updateEventoSuccess = createAction(
  '[Eventos] updateEventoSuccess',
  props<{ evento: Evento }>()
);
export const updateEventoFail = createAction(
  '[Eventos] updateEventoFail',
  props<{ error: any }>()
);
export const orderBy = createAction(
  '[Eventos] orderBy',
  props<{ column: string }>()
);
