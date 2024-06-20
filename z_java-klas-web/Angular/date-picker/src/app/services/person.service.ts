import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable, Subject} from "rxjs";
import {Person} from "../domain/Person";
import {serverUrl} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class PersonService {

  private baseUrl: String = serverUrl
  private resource = '/person';
  private personPath = this.baseUrl + this.resource;
  private _personsUpdated$ = new Subject<Person[]>()

  constructor(private httpClient: HttpClient) {
  }

  findAll() {
    this.httpClient.get<Person[]>(`${this.personPath}`)
      .subscribe(p => this._personsUpdated$.next(p));
  }

  findPerson(id: number): Observable<Person> {
    return this.httpClient.get<Person>(`${this.personPath}/${id}`)
  }

  addPerson(p: Person) {
    // @ts-ignore
    delete p.id;
    this.httpClient.post<Person>(this.personPath, p, {observe: 'response'})
      .subscribe(() => this.findAll());
  }

  update(p: Person) {
    this.httpClient.put<Person>(`${this.personPath}/${p.id}`, p, {observe: 'response'})
      .subscribe(() => this.findAll());
  }

  remove(id: number) {
    this.httpClient.delete<Person>(`${this.personPath}/${id}`)
      .subscribe(() => this.findAll());
  }

  get personsUpdated(): Subject<Person[]> {
    return this._personsUpdated$;
  }

}
