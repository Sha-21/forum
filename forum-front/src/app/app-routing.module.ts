import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {HomeComponent} from "./pages/home/home.component";
import {ConnexionComponent} from './pages/connexion/connexion.component';
import {ForumHomeComponent} from "./pages/forum/forum-home/forum-home.component";
import {ForumSectionComponent} from "./pages/forum/forum-section/forum-section.component";
import {ForumSujetComponent} from "./pages/forum/forum-sujet/forum-sujet.component";

const routes: Routes = [
  {path: "", component: HomeComponent},
  {
    path: "connexion",
    component: ConnexionComponent
  },
  {
    path: "forum-accueil",
    component: ForumHomeComponent
  },
  {
    path: "forum-section/:id",
    component: ForumSectionComponent
  },
  {
    path: "forum-sujet/:id",
    component: ForumSujetComponent
  },
  {
    path: "**",
    redirectTo: "connexion"
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
