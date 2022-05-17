import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { UserLogin } from 'src/app/dtos/user/user-login.model';
import { UserSignup } from 'src/app/dtos/user/user-signup.model';
import { UserWithoutPassword } from 'src/app/dtos/user/user-without-password.model';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
/**
 * Contient les différentes méthodes de l'API
 */
export class UserService {

  constructor(private http: HttpClient) {}

  /**
   * Créé un User et le retourne
   * @param user - User à créer
   */
  signup(user: UserSignup): Observable<UserWithoutPassword> {
    return this.http.post<UserWithoutPassword>(`${environment.apiUrl}/api/auth/signup`, user);
  }

  /**
   * Connecte un user -> retourne le User avec le JWT et le tokenType
   */
  signin(user: UserLogin): Observable<UserWithoutPassword> {
    return this.http.post<UserWithoutPassword>(`${environment.apiUrl}/api/auth/signin`, user)
  }
}
