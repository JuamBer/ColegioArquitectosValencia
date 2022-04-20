interface Permiso {
  authority: string;
}

export interface JwtDTO {
  id: number;
  token: string;
  nombre: string;
  authorities: Permiso[];
}
