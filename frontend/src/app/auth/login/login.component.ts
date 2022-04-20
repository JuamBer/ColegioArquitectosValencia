import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  error: string = "";
  form: FormGroup = this.formBuilder.group({
    nombre: ["", Validators.required],
    password: ["", Validators.required]
  });

  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private authService: AuthService
  ) { }

  ngOnInit(): void {

  }

  login(loginUsuarioDTO: any){
    this.authService.login(loginUsuarioDTO).subscribe(
      (res: any)=>{
        this.router.navigate(['/dashboard/eventos'])
      },
      (err)=>{
        this.error= err.message
      }
    )
  }
}
