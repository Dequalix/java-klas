package org.example.Labs.h13.models;

import lombok.Data;
import org.example.Labs.h10.models.Human;


@Data
public class House<T extends Human> {
    private T inhabitant;

    public House(T inhabitant) {
        this.inhabitant = inhabitant;
    }

    public String toString() {
        return "This house is owned by ["+ inhabitant.getName() + " ("+ inhabitant.getAge() + ") is "+ inhabitant.getGender()+ "] and it says [Hello, my name\n" +
                "is Piet. Nice to meet you!].";
    }

}
