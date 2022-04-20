import { Rol } from "./Rol.model";

export interface RegistroUsuarioDTO {
  nombre: string;
  password: string;
  email: string;
  rol: Rol;
}
