import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Params, Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';
import { ActivatedRoute } from '@angular/router';
import { ChangePasswordDTO } from 'src/app/models/ChangePasswordDTO.model';
import { ThisReceiver } from '@angular/compiler';

@Component({
  selector: 'app-reset-password',
  templateUrl: './reset-password.component.html',
  styleUrls: ['./reset-password.component.scss']
})
export class ResetPasswordComponent implements OnInit {

  token: string = "";

  error: string = "";
  form: FormGroup = this.formBuilder.group({
    password: ["", Validators.required],
    confirmarPassword: ["", Validators.required],
  });

  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private authService: AuthService,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.route.params.subscribe((params: Params) => this.token = params['token']);

  }

  resetPassword(changePasswordDTOsinToken: any){
    console.log(changePasswordDTOsinToken);


    const changePasswordDTO: ChangePasswordDTO = {
      password: changePasswordDTOsinToken.password,
      confirmarPassword: changePasswordDTOsinToken.confirmarPassword,
      token: this.token
    }

    console.log(changePasswordDTO)
    this.authService.changePassword(changePasswordDTO).subscribe(
      (res) => {
        console.log(res)
        this.router.navigate(['/login'])
      },
      (err) => {
        console.log(err)
        if(err.status == 200){
          this.router.navigate(['/login'])
        }
        this.error = err.message;
      }
    )
  }

}
