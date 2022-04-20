import { Pipe, PipeTransform } from '@angular/core';
import { Permiso } from '../models/Permiso.model';

@Pipe({
  name: 'getPermisos'
})
export class GetPermisosPipe implements PipeTransform {

  transform(permisos: Permiso[]): string[] {
    let result: string[] = []

    permisos.forEach(permiso=>{
      result.push(permiso.nombre);
    })

    return result;
  }

}
