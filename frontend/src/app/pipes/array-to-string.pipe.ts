import { Pipe, PipeTransform } from '@angular/core';
import { Rol } from '../models/Rol.model';

@Pipe({
  name: 'arrayToString'
})
export class ArrayToStringPipe implements PipeTransform {

  transform(array: string[]): string {
    let result: string = "[";

    array.forEach(item => {
      result += item + ", "
    })
    result += "]"

    return result;
  }

}
