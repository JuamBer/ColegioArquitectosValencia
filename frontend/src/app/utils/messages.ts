import { Message, Type } from "../models/Message.model"

//GENERIC
export const loadingMessage: Message = {
  text: "Cargando...",
  icon: "information-circle-outline",
  color: "light",
  type: Type.LOADING
}
export const errorMessage: Message = {
  text: "Upsss, Ha Habido Un Error",
  icon: "information-circle-outline",
  color: "danger",
  type: Type.ERROR
}

//USUARIOS
export const loadUsuariosSuccess: Message = {
  text: "¡ Usuarios Cargados Con Éxito !",
  icon: "information-circle-outline",
  color: "success",
  type: Type.LOAD_USUARIOS_SUCCESS
}
export const updateUsuarioSuccess: Message = {
  text: "¡ Usuario Actualizado Con Éxito !",
  icon: "information-circle-outline",
  color: "success",
  type: Type.UPDATE_USUARIO_SUCCESS
}
export const deleteUsuarioSucess: Message = {
  text: "¡ Usuario Eliminado Con Éxito !",
  icon: "information-circle-outline",
  color: "success",
  type: Type.DELETE_USUARIO_SUCCESS
}

//EVENTOS
export const loadEventosSucess: Message = {
  text: "¡ Eventos Cargados Con Éxito !",
  icon: "information-circle-outline",
  color: "success",
  type: Type.LOAD_EVENTOS_SUCCESS
}
export const deleteEventosSucess: Message = {
  text: "¡ Evento Elimnado Con Éxito !",
  icon: "information-circle-outline",
  color: "success",
  type: Type.DELETE_EVENTO_SUCCESS
}
export const createEventoSuccess: Message = {
  text: "¡ Evento Creado Con Éxito !",
  icon: "information-circle-outline",
  color: "success",
  type: Type.DELETE_EVENTO_SUCCESS
}
export const updateEventoSuccess: Message = {
  text: "¡ Evento Actualizado Con Éxito !",
  icon: "information-circle-outline",
  color: "success",
  type: Type.UPDATE_EVENTO_SUCCESS
}
