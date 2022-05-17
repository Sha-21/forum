import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-connexion',
  templateUrl: './connexion.component.html',
  styleUrls: ['./connexion.component.scss']
})
export class ConnexionComponent {

  signin: boolean = true;

  constructor(private router: Router){
  }

  goToHome(){
    this.router.navigate(['']);
  }

  connexion() {
    this.signin = true;
  }

  inscription() {
    this.signin = false;
  }
}
