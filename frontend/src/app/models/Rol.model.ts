import { Permiso } from "./Permiso.model";

export interface Rol {
  id?: number;
  nombre: string;
  permisos?: Permiso[];
}
