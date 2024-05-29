import {Injectable} from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class TitleService {
  private _title: string = "Site title"

  constructor() {
  }

  get title(): string {
    return this._title;
  }
}
