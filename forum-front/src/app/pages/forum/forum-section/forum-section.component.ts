import {Component, OnInit} from '@angular/core';
import {ForumService} from "../../../services/forum.service";
import {ActivatedRoute} from "@angular/router";
import {SectionDto} from "../../../dtos/forum/section-dto.dto";

@Component({
  selector: 'app-forum-section',
  templateUrl: './forum-section.component.html',
  styleUrls: ['./forum-section.component.scss']
})
export class ForumSectionComponent implements OnInit {

  id: number;
  section!: SectionDto;
  newSujet: boolean = false;
  likes:number = 0;

  constructor(private forumService: ForumService, private route: ActivatedRoute) {
    this.id = this.route.snapshot.params['id'];
  }

  ngOnInit(): void {
    this.getSection();
  }

  getSection() {
    return this.forumService.getSection(this.id)
      .subscribe(data => this.section = data);
  }

  createSujet() {
    this.newSujet = true;
  }

  cancelSujet() {
    this.newSujet = false;
  }

  increaseLike(id : number){
    return this.forumService.sujetLike(id).subscribe();
  }

  decreaseLike(id : number){
    return this.forumService.sujetDislike(id).subscribe();
  }

  reloadCurrentPage() {
      window.location.reload();
   }  
}
