package com.MRhood.Animal.controller;

import com.MRhood.Animal.model.Animal;
import com.MRhood.Animal.model.Worker;
import com.MRhood.Animal.repository.AnimalRepository;
import com.MRhood.Animal.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workers")
public class WorkerController {

    @Autowired
    WorkerRepository workerRepository;
    @Autowired
    AnimalRepository animalRepository;

    @GetMapping("")
    public List<Worker> getAll(){
        return workerRepository.getAll();
    }

    @GetMapping("/{id}")
    public Worker getSingle(@PathVariable int id){
        return workerRepository.getSingle(id);
    }

    @PostMapping("/add")
    public String addWorkers(@RequestBody List<Worker> workers){
        return workerRepository.addWorkers(workers);
    }

    @PutMapping("/update/{id}")
    public String updateWorker(@PathVariable int id, @RequestBody Worker worker){

        Worker workerT = workerRepository.getSingle(id);

        if(workerT != null){
            workerT.setW_name(worker.getW_name());
            workerT.setAge(worker.getAge());

            Animal animal = animalRepository.getSingle(worker.getPupil_id());
            if(animal != null){
                workerT.setPupil_id(worker.getPupil_id());
            }else {
                return "Animal with this ID does not exist!";
            }

            return workerRepository.updateWorker(workerT);

        }else {
            return "Worker does not exist !";
        }

    }




}
