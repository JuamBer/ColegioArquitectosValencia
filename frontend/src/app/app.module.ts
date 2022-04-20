import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './auth/login/login.component';
import { RegisterComponent } from './auth/register/register.component';
import { ResetPasswordComponent } from './auth/reset-password/reset-password.component';
import { EventosComponent } from './tablas/eventos/eventos/eventos.component';
import { HttpClientModule } from '@angular/common/http';

//Angular UI
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatTableModule } from '@angular/material/table';
import { MatDialogModule } from '@angular/material/dialog';
import { MatSelectModule } from '@angular/material/select';
import { MatCheckboxModule } from '@angular/material/checkbox';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { SendEmailComponent } from './auth/send-email/send-email.component';
import { SidebarComponent } from './shared/sidebar/sidebar.component';
import { DashboardComponent } from './shared/dashboard/dashboard.component';
import { AuthModule } from './auth/auth.module';
import { UsuariosComponent } from './tablas/usuarios/usuarios/usuarios.component';

//NGRX
import { StoreModule } from '@ngrx/store';
import { appReducers } from './state/app.reducer';
import { StoreDevtoolsModule } from '@ngrx/store-devtools';
import { EffectsModule } from '@ngrx/effects';
import { EventosEffects } from './state/eventos/eventos.effects';
import { UsuariosEffects } from './state/usuarios/usuarios.effects';
import { GetPermisosPipe } from './pipes/get-permisos.pipe';
import { GetPermisosRolPipe } from './pipes/get-permisos-rol.pipe';
import { ArrayToStringPipe } from './pipes/array-to-string.pipe';
import { EditModalUserComponent } from './tablas/usuarios/edit-modal-user/edit-modal-user.component';
import { RolesEffects } from './state/roles/roles.effects';
import { PermisosEffects } from './state/permisos/permisos.effects';
import { CheckPermisoPipe } from './pipes/check-permiso.pipe';
import { CheckRolPermisoPipe } from './pipes/check-rol-permiso.pipe';
import { CheckRolPermisoDisablePipe } from './pipes/check-rol-permiso-disbale.pipe';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { MessageComponent } from './shared/message/message.component';
import { EditModalEventoComponent } from './tablas/eventos/edit-modal-evento/edit-modal-evento.component';


@NgModule({
  declarations: [
    AppComponent,

    EventosComponent,
    UsuariosComponent,
    SidebarComponent,
    DashboardComponent,
    GetPermisosPipe,
    GetPermisosRolPipe,
    ArrayToStringPipe,
    CheckPermisoPipe,
    EditModalUserComponent,
    EditModalEventoComponent,
    CheckRolPermisoPipe,
    CheckRolPermisoDisablePipe,
    MessageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    BrowserAnimationsModule,
    MatInputModule,
    MatButtonModule,
    MatTableModule,
    HttpClientModule,
    AuthModule,
    MatDialogModule,
    MatSelectModule,
    MatCheckboxModule,
    MatSnackBarModule,

    StoreModule.forRoot(appReducers),
    StoreDevtoolsModule.instrument({
      maxAge: 25
    }),
    EffectsModule.forRoot([EventosEffects, UsuariosEffects, RolesEffects, PermisosEffects]),
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
