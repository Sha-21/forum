import {Component, OnInit} from '@angular/core';
import {ForumService} from "../../../services/forum.service";
import {ActivatedRoute} from "@angular/router";
import {SujetDto} from "../../../dtos/forum/sujet-dto.dto";
import {AuthenticationService} from "../../../auth/services/authentication.service";
import {UserWithoutPassword} from "../../../dtos/user/user-without-password.model";
import {MessageDto} from "../../../dtos/forum/message-dto.dto";

@Component({
  selector: 'app-forum-sujet',
  templateUrl: './forum-sujet.component.html',
  styleUrls: ['./forum-sujet.component.scss']
})
export class ForumSujetComponent implements OnInit {

  id: number;
  sujet!: SujetDto;
  messages!: MessageDto[];
  user!: UserWithoutPassword | null;
  newMessage: boolean = false;
  isEditedMessage: boolean = false;
  clickedIndex!: number;

  constructor(private forumService: ForumService, private route: ActivatedRoute, private authService: AuthenticationService) {
    this.user = this.authService.currentUserValue;
    this.id = this.route.snapshot.params['id'];
  }

  ngOnInit(): void {
    this.getSujet();
    this.getMessagesBySujetId(this.id);
  }

  getSujet() {
    return this.forumService.getSujet(this.id)
      .subscribe(data => {
        this.sujet = data;
      });
  }

  getMessagesBySujetId(id: number){
    return this.forumService.getMessagesBySujetId(id).subscribe( data => this.messages = data);
  }

  isCurrentUserIdEqualsAuthorId(authorId: number): boolean {
    if (this.user?.id === authorId) {
      return true;
    } else {
      return false;
    }
  }

  createMessage(){
    this.newMessage = true;
  }

  editMessage(){
    this.isEditedMessage= true;
  }

  cancelMessage() {
    this.newMessage = false;
  }

  increaseLike(id : number){
    return this.forumService.messageLike(id).subscribe();
  }

  decreaseLike(id : number){
    return this.forumService.messageDislike(id).subscribe();
  }

  reloadCurrentPage() {
      window.location.reload();
   }
}
