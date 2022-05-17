import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {UserWithoutPassword} from "../../../dtos/user/user-without-password.model";
import {AngularEditorConfig} from "@kolkov/angular-editor";
import {ActivatedRoute} from "@angular/router";
import {AuthenticationService} from "../../../auth/services/authentication.service";
import {ForumService} from "../../../services/forum.service";

@Component({
  selector: 'app-create-message',
  templateUrl: './create-message.component.html',
  styleUrls: ['./create-message.component.scss']
})
export class CreateMessageComponent implements OnInit {

  sujetId!: number;
  messageForm: FormGroup;
  user!: UserWithoutPassword | null;
  htmlContent = '';
  success: boolean = false;
  config: AngularEditorConfig = {
    editable: true,
    spellcheck: true,
    height: '15rem',
    minHeight: '5rem',
    placeholder: 'Écrire ici...',
    translate: 'no',
    defaultParagraphSeparator: 'p',
    defaultFontName: 'Arial',
    toolbarHiddenButtons: [
      ['bold']
    ]
  };


  constructor(private fb: FormBuilder, private route: ActivatedRoute, private authService: AuthenticationService, private forumService: ForumService) {
    this.user = this.authService.currentUserValue;
    this.sujetId = this.route.snapshot.params['id'];
    this.messageForm = this.fb.group({
      sujet:  fb.group({id: this.sujetId}),
      author:  fb.group({id: this.user?.id}),
      content: ['', Validators.required]
    })
  }

  ngOnInit(): void {
  }

  createMessage() {
    this.forumService.createMessage(this.messageForm.value).subscribe(() => {
      this.success = true;
    });
  }


}
