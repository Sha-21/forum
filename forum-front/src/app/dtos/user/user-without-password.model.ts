import { Roles } from 'src/app/enums/roles.model';

export class UserWithoutPassword {
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

  constructor(username: string, email: string, id: number,  roles: Roles[],
              accessToken: string, tokenType: string) {
    this.id = id;
    this.username = username;
    this.email = email;
    this.roles = roles;
    this.accessToken = accessToken;
    this.tokenType = tokenType;
  }
}
