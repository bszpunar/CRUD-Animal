package com.MRhood.Animal.controller;

import com.MRhood.Animal.model.Animal;
import com.MRhood.Animal.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animals")
public class AnimalController {

    @Autowired
    AnimalRepository animalRepository;

    @GetMapping("")
    public List<Animal> getAll(){
        return animalRepository.getAll();
    }

    @GetMapping("/{id}")
    public Animal getSingle(@PathVariable int id){
        return animalRepository.getSingle(id);
    }

    @PostMapping("/add")
    public String addAnimal(@RequestBody List<Animal> animals){
        return animalRepository.addAnimals(animals);
    }

    @PutMapping("/update/{id}")
    public String updateAnimal(@PathVariable int id, @RequestBody Animal animal){
        return animalRepository.updateAnimal(id,animal);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteAnimal(@PathVariable int id){
        return animalRepository.deleteAnimal(id);
    }


}
