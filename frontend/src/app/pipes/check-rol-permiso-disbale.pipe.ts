import { Pipe, PipeTransform } from '@angular/core';
import { Permiso } from '../models/Permiso.model';
import { Rol } from '../models/Rol.model';

@Pipe({
  name: 'checkRolPermisoDisable'
})
export class CheckRolPermisoDisablePipe implements PipeTransform {

  constructor(
  ){}

  transform(rol: Rol | any, permiso: Permiso) {
    return rol.permisos?.some((p: any) => p.id == permiso.id)
  }

}
