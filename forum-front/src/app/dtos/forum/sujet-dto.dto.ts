import {SectionDto} from "./section-dto.dto";
import {UserWithoutPassword} from "../user/user-without-password.model";
import {MessageDto} from "./message-dto.dto";

export class SujetDto {
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
  section: SectionDto;
  /**
   * author
   */
  author: UserWithoutPassword;
  /**
   * messages
   */
  messages: MessageDto[];
  /**
   * firstMessage
   */
  firstMessage: MessageDto;
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

  constructor(id: number, title: string, section: SectionDto, author: UserWithoutPassword, messages: MessageDto[], firstMessage: MessageDto,createdAt: Date,   updatedAt: Date, likes : number) {
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
