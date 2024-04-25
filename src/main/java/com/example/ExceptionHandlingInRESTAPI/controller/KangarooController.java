package com.example.ExceptionHandlingInRESTAPI.controller;

import com.example.ExceptionHandlingInRESTAPI.entity.Kangaroo;
import com.example.ExceptionHandlingInRESTAPI.exceptions.ZooException;
import com.example.ExceptionHandlingInRESTAPI.validation.ZooKangarooValidation;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/kangaroos")
public class KangarooController {

    Map<Integer, Kangaroo> kangarooMap;

    @PostConstruct
    public void init() {
        this.kangarooMap = new HashMap<>();
        Kangaroo kangaroo1 = new Kangaroo(1, "Jack", 80d, "male", 180, true);
        kangarooMap.put(kangaroo1.getId(), kangaroo1);
    }

    @GetMapping
    public List<Kangaroo> getAll() {
        return kangarooMap.values().stream().toList();
    }

    @GetMapping("/{id}")
    public Kangaroo getById(@PathVariable Integer id) {
        ZooKangarooValidation.isIdValid(id);
        ZooKangarooValidation.checkKangarooExistence(kangarooMap, id, true);
        return kangarooMap.get(id);
    }

}
