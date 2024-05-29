import {Component} from '@angular/core';
import {RouterLink, RouterLinkActive} from "@angular/router";
import {AppComponent} from "../../app.component";
import {TitleService} from "../../services/title.service";

@Component({
  selector: 'app-navbar',
  standalone: true,
  imports: [
    RouterLink,
    RouterLinkActive,
  ],
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.scss'
})
export class NavbarComponent {

  constructor(private titleService: TitleService) {
  }

  getTitle(): string {
    return this.titleService.title;
  }

  protected readonly AppComponent = AppComponent;
}
