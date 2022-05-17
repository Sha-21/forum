import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { first } from 'rxjs/operators';

import { AuthenticationService } from 'src/app/auth/services/authentication.service';

@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.scss']
})
export class SigninComponent {

  /**
   * FormGroup du signin d'un User
   */
  userForm: FormGroup;
  error: string = "";

  constructor(private fb: FormBuilder, private router: Router,
              private authenticationService: AuthenticationService) {
    if(this.authenticationService.currentUserValue) {
      this.router.navigate(['']);
    }
    this.userForm = this.fb.group({
      username: ["", [Validators.required, Validators.minLength(4)]],
      password : ["", [Validators.required, Validators.minLength(4)]]
    })
  }

  get form() {return this.userForm.controls;}

  /**
   * Connecte un User
   */
  signin() {
    this.authenticationService.login(this.form['username'].value, this.form['password'].value)
    .pipe(first()).subscribe({
      next: () => {
        this.router.navigate(['']);
      },
      error: error => {
        this.error = error.error.message;
      }
    });
  }
}
