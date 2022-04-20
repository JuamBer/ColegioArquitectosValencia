import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';

//NGRX
import { AppState } from './state/app.reducer';
import { Store } from '@ngrx/store';
import * as authActions from 'src/app/state/auth/auth.actions';
import { Message, Type } from './models/Message.model';
import { MessageComponent } from './shared/message/message.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit{

  constructor(
    private store: Store<AppState>,
    private _snackBar: MatSnackBar
  ){

  }
  ngOnInit(): void {
    this.store.select(store => store.usuarios.message).subscribe(
      message => {
        if(message){
          this.openSnackBar(message);
        }
      }
    )

    this.store.select(store => store.eventos.message).subscribe(
      message => {
        if (message) {
          this.openSnackBar(message);
        }
      }
    )

  }
  title = 'colegio_arquitectos_valencia_front';

  openSnackBar(message: Message) {
    this._snackBar.openFromComponent(MessageComponent, {
      duration: 2000,
      data: message,
    });
  }
}
