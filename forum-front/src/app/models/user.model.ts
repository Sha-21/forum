import { Roles } from 'src/app/enums/roles.model';

export class User {
  /**
   * id, unique
   */
  id: number;
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
  /**
   * JWT
   */
  accessToken: string;
  /**
   * type de Token
   */
  tokenType: string;

  constructor(username: string, email: string, password: string, id: number,  roles: Roles[],
              accessToken: string, tokenType: string) {
    this.id = id;
    this.username = username;
    this.email = email;
    this.roles = roles;
    this.password = password;
    this.accessToken = accessToken;
    this.tokenType = tokenType;
  }
}
