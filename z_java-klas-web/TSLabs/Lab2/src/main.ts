import {Person} from "./Person";

let p: Person = new Person("Peter", "Peterson");
p.lastName = "Pieter";

console.log("Hello " + p.getFullName());
