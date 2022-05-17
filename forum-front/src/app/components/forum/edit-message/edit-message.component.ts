import {Component, Input, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute} from "@angular/router";
import {ForumService} from "../../../services/forum.service";
import {AngularEditorConfig} from "@kolkov/angular-editor";

@Component({
  selector: 'app-edit-message',
  templateUrl: './edit-message.component.html',
  styleUrls: ['./edit-message.component.scss']
})
export class EditMessageComponent implements OnInit {

  @Input() messageId!: number;
  editMessageForm: FormGroup;
  htmlContent = '';
  success: boolean = false;
  config: AngularEditorConfig = {
    editable: true,
    spellcheck: true,
    height: '15rem',
    minHeight: '5rem',
    placeholder: 'Modifier mon message ici...',
    translate: 'no',
    defaultParagraphSeparator: 'p',
    defaultFontName: 'Arial',
    toolbarHiddenButtons: [
      ['bold']
    ]
  };

  constructor(private fb: FormBuilder, private route: ActivatedRoute, private forumService: ForumService) {
    this.editMessageForm = this.fb.group({
      content: ['', Validators.required]
    });
  }

  ngOnInit(): void {

  }

  editMessage(messageId: number) {
    this.forumService.editMessage(this.editMessageForm.value, messageId).subscribe(() => {
      this.success = true;
    });
  }

}
