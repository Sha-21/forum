import {SujetDto} from "./sujet-dto.dto";

export class SectionDto {
  /**
   * id, unique
   */
  id: number;
  /**
   * title
   */
  title: string;
  /**
   * detail
   */
  detail: string;
  /**
   * sujets
   */
   /**
   * likes
   */
  sujets: SujetDto[];

  constructor(id: number, title: string, detail: string, sujets: SujetDto[]) {
    this.id = id;
    this.title = title;
    this.detail = detail;
    this.sujets = sujets;
  }
}
