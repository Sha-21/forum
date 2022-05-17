export class UserLogin {
  /**
   * username
   */
  username: string;
  /**
   * password
   */
  password: string;

  constructor(username: string, password: string) {
    this.username = username;
    this.password = password;
  }
}
