package com.example.ExceptionHandlingInRESTAPI.validation;

import com.example.ExceptionHandlingInRESTAPI.entity.Kangaroo;
import com.example.ExceptionHandlingInRESTAPI.exceptions.ZooException;
import org.springframework.http.HttpStatus;

import java.util.Map;

public class ZooKangarooValidation {

    public static void isIdValid(Integer id) {
        if (id == null || id <= 0) {
            throw new ZooException("Id must be bigger than zero. Your Id " + id,
                    HttpStatus.BAD_REQUEST);
        }
    }

    public static void checkKangarooExistence(Map<Integer, Kangaroo> kangarooMap, Integer id,
                                              boolean shouldBeExist) {
        if (shouldBeExist) {
            //is kangaroo in map?
            if (!kangarooMap.containsKey(id)) {
                throw new ZooException("Kangaroo not found index: " + id, HttpStatus.NOT_FOUND);
            }
        } else {
            if (kangarooMap.containsKey(id)) {
                throw new ZooException("Kangaroo already exist with id: " + id,
                        HttpStatus.BAD_REQUEST);
            }
        }

    }
}
