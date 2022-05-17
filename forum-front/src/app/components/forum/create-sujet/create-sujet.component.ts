import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute} from "@angular/router";
import {AuthenticationService} from "../../../auth/services/authentication.service";
import {UserWithoutPassword} from "../../../dtos/user/user-without-password.model";
import {AngularEditorConfig} from "@kolkov/angular-editor";
import {ForumService} from "../../../services/forum.service";

@Component({
  selector: 'app-create-sujet',
  templateUrl: './create-sujet.component.html',
  styleUrls: ['./create-sujet.component.scss']
})
export class CreateSujetComponent implements OnInit {

  sectionId!: number;
  sujetForm: FormGroup;
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
    this.sectionId = this.route.snapshot.params['id'];
    this.sujetForm = this.fb.group({
      title: ['', Validators.required],
      section: fb.group({id: this.sectionId}),
      author: fb.group({id: this.user?.id}),
      firstMessage: ['', Validators.required]
    })
  }

  ngOnInit(): void {
  }

  createSujet() {
    this.forumService.createSujet(this.sujetForm.value).subscribe(() => {
      this.success = true;
    });
  }

}
