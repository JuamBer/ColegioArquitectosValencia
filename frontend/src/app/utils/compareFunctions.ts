export function compareId(a: any, b: any) {
  if (a.id < b.id) { return -1; }
  if (a.id > b.id) { return 1; }
  return 0;
}
export function compareIdDesc(a: any, b: any) {
  if (a.id > b.id) { return -1; }
  if (a.id < b.id) { return 1; }
  return 0;
}

export function compareNombre(a: any, b: any) {
  if (a.nombre < b.nombre) { return -1; }
  if (a.nombre > b.nombre) { return 1; }
  return 0;
}
export function compareNombreDesc(a: any, b: any) {
  if (a.nombre > b.nombre) { return -1; }
  if (a.nombre < b.nombre) { return 1; }
  return 0;
}
export function compareFecha(a: any, b: any) {
  if (a.fecha < b.fecha) { return -1; }
  if (a.fecha > b.fecha) { return 1; }
  return 0;
}
export function compareFechaDesc(a: any, b: any) {
  if (a.fecha > b.fecha) { return -1; }
  if (a.fecha < b.fecha) { return 1; }
  return 0;
}
export function compareDescripcion(a: any, b: any) {
  if (a.descripcion < b.descripcion) { return -1; }
  if (a.descripcion > b.descripcion) { return 1; }
  return 0;
}
export function compareDescripcionDesc(a: any, b: any) {
  if (a.descripcion > b.descripcion) { return -1; }
  if (a.descripcion < b.descripcion) { return 1; }
  return 0;
}
export function compareWeb(a: any, b: any) {
  if (a.web < b.web) { return -1; }
  if (a.web > b.web) { return 1; }
  return 0;
}
export function compareWebDesc(a: any, b: any) {
  if (a.web > b.web) { return -1; }
  if (a.web < b.web) { return 1; }
  return 0;
}
