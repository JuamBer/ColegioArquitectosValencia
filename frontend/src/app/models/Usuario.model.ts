import { Rol } from "./Rol.model";

export interface Usuario {
  id?: number;
  nombre: string;
  password: string;
  email: string;
  rol: Rol;
  permisos: any;
  token?: string;
}
