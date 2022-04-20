import { createAction, props } from '@ngrx/store';

export const isLoading = createAction('[UI Component] IsLoading');
export const stopLoading = createAction('[UI Component] StopLoading');

export const goTo = createAction(
  '[UI Component] goTo',
  props<{ page: string }>()
  );
