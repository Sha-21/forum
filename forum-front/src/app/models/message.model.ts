import {User} from "./user.model";
import {Sujet} from "./sujet.model";

export class Message {
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
  author: User;
  /**
   * sujet
   */
  sujet: Sujet;
  /**
   * createdAt
   */
  createdAt: Date;
  /**
   * updatedAt
   */
  updatedAt: Date;
  /**
  * likes
  */
  likes: number;

  constructor(id: number, content: string, author: User, sujet: Sujet, createdAt: Date, updatedAt: Date, likes: number) {
    this.id = id;
    this.content = content;
    this.author = author;
    this.sujet = sujet;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.likes = likes;
  }
}
