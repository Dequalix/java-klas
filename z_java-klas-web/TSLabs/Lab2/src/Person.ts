export class Person {

    get firstName(): undefined | string {
        return this._firstName;
    }

    set firstName(value: string) {
        this._firstName = value;
    }

    get lastName(): undefined | string {
        return this._lastName;
    }

    set lastName(value: string) {
        this._lastName = value;
    }

    getFullName(): string {
        return this.firstName + " " + this.lastName;
    }


    constructor(private _firstName: string, private _lastName: string) {
    }

}