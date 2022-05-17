import {Section} from "./section.model";
import {User} from "./user.model";
import {Message} from "./message.model";

export class Sujet {
  /**
   * id, unique
   */
  id: number;
  /**
   * title
   */
  title: string;
  /**
   * section
   */
  section: Section;
  /**
   * author
   */
  author: User;
  /**
   * messages
   */
  messages: Message[];
  /**
   * firstMessage
   */
  firstMessage: Message;
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
  likes: number;

  constructor(id: number, title: string, section: Section, author: User, messages: Message[], firstMessage: Message,  createdAt: Date,   updatedAt: Date, likes: number) {
    this.id = id;
    this.title = title;
    this.section = section;
    this.author = author;
    this.messages = messages;
    this.firstMessage = firstMessage;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.likes = likes;
  }
}
