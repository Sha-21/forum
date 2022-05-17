import {UserWithoutPassword} from "../user/user-without-password.model";
import {SujetDto} from "./sujet-dto.dto";

export class MessageDto {
  /**
   * id, unique
   */
  id: number;
  /**
   * content
   */
  content: string;
  /**
   * author
   */
  author: UserWithoutPassword;
  /**
   * sujet
   */
  sujet: SujetDto;
  /**
   * createdAt
   */
  createdAt: Date;
  /**
   * updatedAt
   */
  updatedAt: Date
  /**
  * likes
  */
  likes : number;

  constructor(id: number, content: string, author: UserWithoutPassword, sujet: SujetDto, createdAt: Date, updatedAt: Date, likes : number) {
    this.id = id;
    this.content = content;
    this.author = author;
    this.sujet = sujet;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.likes = likes;
  }
}
