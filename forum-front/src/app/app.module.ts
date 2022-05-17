import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {HomeComponent} from './pages/home/home.component';
import {NavbarComponent} from './components/shared/navbar/navbar.component';
import {FooterComponent} from './components/shared/footer/footer.component';
import {ConnexionComponent} from './pages/connexion/connexion.component';
import {SigninComponent} from './components/login/signin/signin.component';
import {SignupComponent} from './components/login/signup/signup.component';

import {JwtInterceptor} from './helpers/jwt.interceptor';
import {ForumHomeComponent} from './pages/forum/forum-home/forum-home.component';
import {ForumSectionComponent} from './pages/forum/forum-section/forum-section.component';
import { ForumSujetComponent } from './pages/forum/forum-sujet/forum-sujet.component';
import { CreateSujetComponent } from './components/forum/create-sujet/create-sujet.component';
import { AngularEditorModule } from '@kolkov/angular-editor';
import { CreateMessageComponent } from './components/forum/create-message/create-message.component';
import { EditMessageComponent } from './components/forum/edit-message/edit-message.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    NavbarComponent,
    FooterComponent,
    SigninComponent,
    ConnexionComponent,
    SignupComponent,
    ForumHomeComponent,
    ForumSectionComponent,
    ForumSujetComponent,
    CreateSujetComponent,
    CreateMessageComponent,
    EditMessageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    AngularEditorModule
  ],
  providers: [{ provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true }],
  bootstrap: [AppComponent]
})
export class AppModule { }
