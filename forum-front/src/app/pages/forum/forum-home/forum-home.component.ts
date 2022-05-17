import {Component, OnInit} from '@angular/core';
import {ForumService} from "../../../services/forum.service";
import {SectionDto} from "../../../dtos/forum/section-dto.dto";

@Component({
  selector: 'app-forum-home',
  templateUrl: './forum-home.component.html',
  styleUrls: ['./forum-home.component.scss']
})
export class ForumHomeComponent implements OnInit {

  sections!: SectionDto[];

  constructor(private forumService: ForumService) {
  }

  ngOnInit(): void {
    this.getSections();
  }

  getSections(){
    return this.forumService.getSections()
      .subscribe(data => this.sections = data);
  }

}
