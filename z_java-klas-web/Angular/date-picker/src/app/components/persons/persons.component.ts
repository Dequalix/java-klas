import {Component, OnInit} from '@angular/core';
import {AsyncPipe} from "@angular/common";
import {RouterLink} from "@angular/router";
import {Observable} from "rxjs";
import {Person} from "../../domain/Person";
import {PersonService} from "../../services/person.service";
import {MatPaginator, PageEvent} from "@angular/material/paginator";

@Component({
  selector: 'app-persons',
  standalone: true,
  imports: [
    AsyncPipe,
    RouterLink,
    MatPaginator
  ],
  templateUrl: './persons.component.html',
  styleUrl: './persons.component.scss'
})
export class PersonsComponent implements OnInit {
  persons: Person[] = [];
  persons$!: Observable<Person[]>;

  totalItems = 100;
  pageSize = 10;
  currentPage = 0;
  pageSizeOptions = [10, 25]

  constructor(private personService: PersonService) {
  }

  ngOnInit() {
    this.persons$ = this.personService.personsUpdated;
    this.getAllPersons();
  }

  pageChanged(event: PageEvent) {
    this.currentPage = event.pageIndex;
    this.pageSize = event.pageSize;
    this.getAllPersons()
  }

  getAllPersons() {
    this.personService.findAll();
    this.persons$?.subscribe(r => {
        this.totalItems = r.length
        let start = this.currentPage * this.pageSize;
        let end = start + this.pageSize;
        this.persons = r.slice(start, end);
      }
    )
  }

  removePerson(id: number) {
    if (confirm("Are you sure you want to delete this user?")) {
      this.personService.remove(id);
    }
  }
}
