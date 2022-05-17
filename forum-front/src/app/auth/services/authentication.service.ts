import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { UserLogin } from 'src/app/dtos/user/user-login.model';
import { UserSignup } from 'src/app/dtos/user/user-signup.model';
import { UserWithoutPassword } from 'src/app/dtos/user/user-without-password.model';
import { UserService } from 'src/app/services/user.service';
import { Roles } from 'src/app/enums/roles.model';

@Injectable({ providedIn: 'root' })
export class AuthenticationService {
    private currentUserSubject: BehaviorSubject<UserWithoutPassword | null>;
    public currentUser: Observable<UserWithoutPassword | null>;

    constructor( private service: UserService) {
      if(sessionStorage.getItem('user') !== null) {
        this.currentUserSubject = new BehaviorSubject<UserWithoutPassword | null>(JSON.parse(sessionStorage.getItem('user')!) as UserWithoutPassword);
      }
      else {
        this.currentUserSubject = new BehaviorSubject<UserWithoutPassword | null>(null);
      }
        this.currentUser = this.currentUserSubject.asObservable();
    }

    public get currentUserValue(): UserWithoutPassword | null {
        return this.currentUserSubject === null ? null : this.currentUserSubject.value;
    }

    signup(username: string, email:string, password: string, roles: Roles[]) {
      return this.service.signup(new UserSignup(username, email, password, roles));
    }

    login(username: string, password: string) {
        return this.service.signin(new UserLogin(username, password))
            .pipe(map(user => {
                sessionStorage.setItem('user', JSON.stringify(user));
                this.currentUserSubject!.next(user);
                return user;
            }));
    }

    logout() {
        // remove user from local storage to log user out
        sessionStorage.removeItem('user');
        if(this.currentUserSubject !== null) {
          this.currentUserSubject.next(null);
        }
    }
}
