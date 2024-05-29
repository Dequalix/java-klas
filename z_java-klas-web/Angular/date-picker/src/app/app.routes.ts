import {Routes} from '@angular/router';
import {HomeComponent} from "./components/home/home.component";
import {PersonsComponent} from "./components/persons/persons.component";
import {PersonComponent} from "./components/person/person.component";

export const routes: Routes = [
  {path: '', redirectTo: '', pathMatch: "full"},
  {path: '', component: HomeComponent},
  {path: 'persons', component: PersonsComponent,
  children: [
    {path: 'pId', component: PersonComponent}
  ]},
  {path: 'person/:id', component: PersonComponent}
];
