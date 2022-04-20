import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EventosComponent } from '../../tablas/eventos/eventos/eventos.component';
import { UsuariosComponent } from '../../tablas/usuarios/usuarios/usuarios.component';
import { DashboardComponent } from './dashboard.component';

const routes: Routes = [
  {
    path: '',
    component: DashboardComponent,
    children: [
      {
        path: 'eventos',
        component: EventosComponent,
      },
      {
        path: 'usuarios',
        component: UsuariosComponent,
      },
    ]
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DashboardRoutingModule { }
