import {Component, Input, OnInit} from '@angular/core';
import {PersonService} from "../../services/person.service";
import {ActivatedRoute, Router} from "@angular/router";
import {MatFormField} from "@angular/material/form-field";
import {MatInput} from "@angular/material/input";
import {FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators} from "@angular/forms";
import {Person} from "../../domain/Person";

@Component({
  selector: 'app-person',
  standalone: true,
  imports: [
    MatFormField,
    MatInput,
    ReactiveFormsModule,
    FormsModule
  ],
  templateUrl: './person.component.html',
  styleUrl: './person.component.scss'
})
export class PersonComponent implements OnInit {
  @Input() editMode = true;
  person: Person = {} as Person
  personForm!: FormGroup;
  mode: String = 'edit'

  constructor(private route: ActivatedRoute
    , private router: Router
    , private personService: PersonService
    , private fb: FormBuilder) {
  }

  ngOnInit() {
    const idParam = this.route.snapshot.paramMap.get('id');
    this.personForm = this.fb.group({
      id: this.fb.control(''),
      firstName: this.fb.control('', [Validators.required]),
      lastName: this.fb.control('', [Validators.required]),
      age: this.fb.control('', [Validators.required])
    })
    if (idParam === 'add') {
      this.mode = 'add'
      this.editMode = false;
    } else {
      this.loadPerson(idParam);
    }
  }

  loadPerson(idParam: String | null) {
    let id: number = (idParam !== null) ? +idParam : -1;
    this.personService.findPerson(id).subscribe(r => {
      this.personForm.patchValue(r);
      this.person = r
    });
  }


  save() {
    if (this.editMode) {
      this.personService.update(this.personForm.value);
    } else {
      this.personService.addPerson(this.personForm.value);
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
