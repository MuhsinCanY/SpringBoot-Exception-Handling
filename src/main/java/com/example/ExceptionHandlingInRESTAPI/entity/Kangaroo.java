package com.example.ExceptionHandlingInRESTAPI.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Kangaroo extends Animal {
    private double height;
    private boolean isAggressive;

    public Kangaroo(int id, String name, double weight, String gender, double height, boolean isAggressive) {
        super(id, name, weight, gender);
        this.height = height;
        this.isAggressive = isAggressive;
    }
}
