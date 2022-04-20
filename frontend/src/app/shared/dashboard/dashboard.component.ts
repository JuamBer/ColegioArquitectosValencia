import { IfStmt } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Permiso } from '../../models/Permiso.model';
import { AuthService } from '../../services/auth.service';
import { EventoService } from '../../services/evento.service';

const ELEMENT_DATA: any[] = [
  { position: 0, name: 'Loading Info', email: "Loading Info" }
];

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {


  constructor(
  ) { }

  ngOnInit(): void {


  }






}
