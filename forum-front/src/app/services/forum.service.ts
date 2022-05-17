import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from 'src/environments/environment';
import {Observable} from "rxjs";
import {SectionDto} from "../dtos/forum/section-dto.dto";
import {SujetDto} from "../dtos/forum/sujet-dto.dto";
import {MessageDto} from "../dtos/forum/message-dto.dto";

@Injectable({
  providedIn: 'root'
})
export class ForumService {

  constructor(private http: HttpClient) {
  }

  getSections(): Observable<SectionDto[]> {
    return this.http.get<SectionDto[]>(`${environment.apiUrl}/api/sections`);
  }

  getSection(id: number): Observable<SectionDto> {
    return this.http.get<SectionDto>(`${environment.apiUrl}/api/sections/` + id);
  }

  getSujet(id: number): Observable<SujetDto> {
    return this.http.get<SujetDto>(`${environment.apiUrl}/api/sujets/` + id);
  }

  createSujet(sujet: SujetDto){
    return this.http.post<SujetDto>(`${environment.apiUrl}/api/sujets/`, sujet);
  }

  getMessagesBySujetId(id: number): Observable<MessageDto[]> {
    return this.http.get<MessageDto[]>(`${environment.apiUrl}/api/messages/sujet-` + id);
  }

  createMessage(message: MessageDto){
    return this.http.post<MessageDto>(`${environment.apiUrl}/api/messages/`, message);
  }

  editMessage(message: MessageDto, id: number){
    return this.http.put<MessageDto>(`${environment.apiUrl}/api/messages/` + id, message);
  }

  sujetLike(id: number){
    return this.http.put(`${environment.apiUrl}/api/sujets/${id}/like`,{});
  }

  sujetDislike(id: number){
    return this.http.put(`${environment.apiUrl}/api/sujets/${id}/dislike`, {});
  }

  messageLike(id: number){
    return this.http.put(`${environment.apiUrl}/api/messages/${id}/like`, {});
  }

  messageDislike(id: number){
    return this.http.put(`${environment.apiUrl}/api/messages/${id}/dislike`, {});
  }
}
