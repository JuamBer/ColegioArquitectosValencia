import { createReducer, on } from '@ngrx/store';
import { goTo, isLoading, stopLoading } from './ui.actions';

export interface State {
  isLoading: boolean;
  page: string;
}

export const initialState: State = {
  isLoading: false,
  page: "dashboard/eventos"
}

export const uiReducer = createReducer(initialState,

  on(isLoading, state => ({ ...state, isLoading: true})),
  on(stopLoading, state => ({ ...state, isLoading: false })),

  on(goTo, (state, {page}) => ({ ...state, page: page })),

);

