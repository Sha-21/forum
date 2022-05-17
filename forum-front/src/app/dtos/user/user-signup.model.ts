import { Roles } from 'src/app/enums/roles.model';

export class UserSignup {
  /**
   * username
   */
  username: string;
  /**
   * roles du User
   */
  roles: Roles[];
  /**
   * password
   */
  password: string;
  /**
   * email
   */
  email: string;

  constructor(username: string, email: string, password: string, roles: Roles[]) {
    this.username = username;
    this.email = email;
    this.roles = roles;
    this.password = password;
  }
}
