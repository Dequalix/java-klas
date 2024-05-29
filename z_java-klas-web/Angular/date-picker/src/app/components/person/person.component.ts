import {Component, Input, OnInit} from '@angular/core';
import {PersonService} from "../../services/person.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Person} from "../../domain/Person";
import {MatFormField} from "@angular/material/form-field";
import {MatInput} from "@angular/material/input";
import {FormsModule, NgForm} from "@angular/forms";

@Component({
  selector: 'app-person',
  standalone: true,
  imports: [
    MatFormField,
    MatInput,
    FormsModule
  ],
  templateUrl: './person.component.html',
  styleUrl: './person.component.scss'
})
export class PersonComponent implements OnInit {
  @Input() editMode = true;
  person: Person = {} as Person
  mode: String = 'edit'

  constructor(private route: ActivatedRoute
    , private router: Router
    , private personService: PersonService) {
  }

  ngOnInit() {
    const idParam = this.route.snapshot.paramMap.get('id');
    if (idParam === 'add') {
      this.mode = 'add'
      this.editMode = false;
    } else {
      this.loadPerson(idParam);
    }
  }

  loadPerson(idParam: String | null) {
    let id: number = (idParam !== null) ? +idParam : -1;
    this.personService.findPerson(id).subscribe(r => this.person = r);
  }

  save(personForm: NgForm) {
    if (this.editMode) {
      this.personService.update(personForm.value);
    } else {
      this.personService.addPerson(personForm.value);
    }
    this.back()
  }

  cancel() {
    this.back();
  }

  back() {
    this.router.navigate(['persons']);
  }
}
