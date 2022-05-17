import {Sujet} from "./sujet.model";

export class Section {
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
  sujets: Sujet[];

  constructor(id: number, title: string, detail: string, sujets: Sujet[]) {
    this.id = id;
    this.title = title;
    this.detail = detail;
    this.sujets = sujets;
  }
}
