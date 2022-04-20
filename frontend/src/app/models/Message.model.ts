export enum Type {
  LOADING,
  ERROR,

  LOAD_USUARIOS_SUCCESS,
  UPDATE_USUARIO_SUCCESS,
  DELETE_USUARIO_SUCCESS,

  LOAD_EVENTOS_SUCCESS,
  UPDATE_EVENTO_SUCCESS,
  DELETE_EVENTO_SUCCESS,
}

export interface Message {
  text: string;
  icon: string;
  color: "primary" | "secondary" |  "tertiary" | "success" | "warning" | "danger" | "light" | "medium"| "dark";
  type: Type
}
