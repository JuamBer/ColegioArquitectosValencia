import { Pipe, PipeTransform } from '@angular/core';
import { Permiso } from '../models/Permiso.model';
import { Rol } from '../models/Rol.model';
import { UsuarioService } from '../services/usuario.service';

@Pipe({
  name: 'checkPermiso'
})
export class CheckPermisoPipe implements PipeTransform {

  constructor(
    private usuarioService: UsuarioService
  ){

  }

  transform(permiso: Permiso, id_user: number) {
    return this.usuarioService.checkPermiso(permiso,id_user).then(
      (res: any)=>{
        return res
      }
    ).catch(
      (err)=>{
        console.log(err);
        return false
      }
    );
  }

}
