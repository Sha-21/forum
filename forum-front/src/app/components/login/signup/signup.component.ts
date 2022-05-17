import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Roles } from 'src/app/enums/roles.model';
import { Router } from '@angular/router';
import { first } from 'rxjs/operators';

import { AuthenticationService } from 'src/app/auth/services/authentication.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.scss']
})
export class SignupComponent {

  /**
   * FormGroup du signin d'un User
   */
  userForm: FormGroup;
  error : string = "";
  emailPattern = "^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$";
  errorTriggered: boolean = false;

  constructor(private fb: FormBuilder, private router: Router,
              private authenticationService: AuthenticationService) {
    if(this.authenticationService.currentUserValue) {
      this.router.navigate(['/home']);
    }
    this.userForm = this.fb.group({
      username: ["", [Validators.required, Validators.minLength(3)]],
      email: ["", [Validators.required, Validators.pattern(this.emailPattern)]],
      password : ["", [Validators.required], Validators.minLength(6),],
      confirmPassword : ["", [Validators.required, Validators.minLength(6)]]
    },
    {
      validator: this.checkMatchValidator('password', 'confirmPassword')
    });
  }

  get form() {return this.userForm.controls;}

  checkMatchValidator(controlName: string, matchingControlName: string){
    return (formGroup: FormGroup) => {
      const control = formGroup.controls[controlName];
      const matchingControl = formGroup.controls[matchingControlName];
      if (matchingControl.errors && !matchingControl.errors['confirmedValidator']) {
        return;
      }
      if (control.value !== matchingControl.value) {
        matchingControl.setErrors({ confirmedValidator: true });
      }
      else {
        matchingControl.setErrors({});
      }
    }
  }

  /**
   * Connecte un User
   */
  signup() {
    this.authenticationService.signup(this.form['username'].value, this.form['email'].value,
                                      this.form['password'].value, [Roles.USER])
    .pipe(first()).subscribe({
      next: () => {
        this.router.navigate(['login']);
      },
      error: error => {
        this.error = error.error.message;
        this.errorTriggered = true;
      }
    });
  }
}
