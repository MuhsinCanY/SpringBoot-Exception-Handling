package com.example.ExceptionHandlingInRESTAPI.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Koala extends Animal {
    private double sleepHour;

    public Koala(int id, String name, double weight, String gender, double sleepHour) {
        super(id, name, weight, gender);
        this.sleepHour = sleepHour;
    }
}
