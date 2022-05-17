import { Component } from '@angular/core';
import { UserWithoutPassword } from 'src/app/dtos/user/user-without-password.model';

import { AuthenticationService } from 'src/app/auth/services/authentication.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'forum-front';
  user: UserWithoutPassword | null = null;
  userSubscription;

  constructor(private authenticationService: AuthenticationService) {
    if(sessionStorage.getItem('user') !== null) {
      this.user = JSON.parse(sessionStorage.getItem('user')!) as UserWithoutPassword;
    }
    this.userSubscription = this.authenticationService.currentUser.subscribe(user => this.user = user);
  }
}
