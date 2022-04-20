import { Pipe, PipeTransform } from '@angular/core';
import { Rol } from '../models/Rol.model';

@Pipe({
  name: 'getPermisosRol'
})
export class GetPermisosRolPipe implements PipeTransform {

  transform(rol: Rol): string[] {
    let result: string[] = []

    if (rol.permisos){
      rol.permisos.forEach(permiso => {
        result.push(permiso.nombre);
      })
    }


    return result;
  }

}
