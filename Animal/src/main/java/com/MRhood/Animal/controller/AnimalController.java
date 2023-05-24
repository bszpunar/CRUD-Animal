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
    public String updateAnimal(@PathVariable("id") int id, @RequestBody Animal animal){

        Animal animalT = animalRepository.getSingle(id);

        if(animalT != null){
            animalT.setAname(animal.getAname());
            animalT.setAge(animal.getAge());
            return animalRepository.updateAnimal(animalT);
        }else {
            return "Animal does not exist !";
        }

    }

    @PatchMapping("/update/{id}")
    public String partiallyUpdate(@PathVariable int id, @RequestBody Animal animal){

        Animal animalT = animalRepository.getSingle(id);

        if(animalT != null){
            if(animal.getAname() != null) animalT.setAname(animal.getAname());
            if(animal.getAge() > 0) animalT.setAge(animal.getAge());

            return animalRepository.updateAnimal(animalT);
        }else{
            return "Animal does not exist !";
        }

    }

    @DeleteMapping("/delete/{id}")
    public String deleteAnimal(@PathVariable("id") int id){
        return animalRepository.deleteAnimal(id);
    }


}
