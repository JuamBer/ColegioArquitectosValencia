import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-send-email',
  templateUrl: './send-email.component.html',
  styleUrls: ['./send-email.component.scss']
})
export class SendEmailComponent implements OnInit {

  success: string = "";
  error: string = "";
  form: FormGroup = this.formBuilder.group({
    email: ["", Validators.required],
  });

  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private authService: AuthService
  ) { }

  ngOnInit(): void {
  }

  sendEmail() {

    console.log(this.form.value.email)
    this.authService.sendEmail(this.form.value.email).subscribe(
      (res: any) => {
        console.log(res)
        this.success = "Correo Enviado Con Exito"
      },
      (err) => {
        this.error = err.message
      }
    )
  }
}
