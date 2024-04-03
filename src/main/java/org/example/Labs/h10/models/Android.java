package org.example.Labs.h10.models;

import lombok.Data;

@Data
public class Android extends Human implements ChargeAble {
    private int power;

    public Android(int power) {
        this.power = power;
    }

    @Override
    public String greet() {
        return "I'm only half human, but human still.... My energy level is " + power + "%.";
    }

    @Override
    public int charge(int amount) {
        return power + amount <= 100 ? power = power + amount : power;
    }
}
