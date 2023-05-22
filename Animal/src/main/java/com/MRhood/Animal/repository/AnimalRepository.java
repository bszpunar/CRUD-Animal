package com.MRhood.Animal.repository;

import com.MRhood.Animal.model.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AnimalRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Animal> getAll(){
        return jdbcTemplate.query("SELECT id,aname,age FROM animal ", BeanPropertyRowMapper.newInstance(Animal.class));
    }

    public Animal getSingle(int id) {
        return jdbcTemplate.queryForObject("SELECT id,aname,age FROM animal WHERE id=?", BeanPropertyRowMapper.newInstance(Animal.class), id);
    }

    public String addAnimals(List<Animal> animals) {
        animals.forEach(animal -> jdbcTemplate.update("INSERT INTO animal (aname, age) VALUES (?, ?)", animal.getAname(), animal.getAge()));
        return "Success";
    }


}
