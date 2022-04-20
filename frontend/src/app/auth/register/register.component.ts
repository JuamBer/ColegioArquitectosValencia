import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { RegistroUsuarioDTO } from 'src/app/models/RegistroUsuarioDTO.model';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  error: string = "";
  form: FormGroup = this.formBuilder.group({
    nombre: ["", Validators.required],
    email: ["", [Validators.required, Validators.email]],
    password: ["", Validators.required]
  });

  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private authService: AuthService
  ) { }

  ngOnInit(): void {
  }

  register(registroUsuarioDTOsinRol: any){

    let registroUsuarioDTO: RegistroUsuarioDTO = {
      ...registroUsuarioDTOsinRol,
      rol: {
        nombre: "ROLE_USER"
      }
    }

    this.authService.register(registroUsuarioDTO).subscribe(
      (res)=>{
        console.log(res)
        this.router.navigate(['/login'])
      },
      (err) => {
        this.error = err.message
      }
    )
  }
}
