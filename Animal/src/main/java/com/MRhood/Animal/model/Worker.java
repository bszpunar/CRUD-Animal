package com.MRhood.Animal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Worker {

    private int id;
    private String w_name;
    private int age;
    private int pupil_id;

}
