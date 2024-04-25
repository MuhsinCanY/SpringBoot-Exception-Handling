package com.example.ExceptionHandlingInRESTAPI.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Animal {
    private int id;
    private String name;
    private double weight;
    private String gender;
}
