package com.MRhood.Animal.repository;

import com.MRhood.Animal.model.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AnimalRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Animal> getAll(){
        return jdbcTemplate.query("SELECT id,a_name,age FROM animal ", BeanPropertyRowMapper.newInstance(Animal.class));
    }

    public Animal getSingle(int id) {
        try {
            return jdbcTemplate.queryForObject("SELECT id,a_name,age FROM animal WHERE id=?", BeanPropertyRowMapper.newInstance(Animal.class), id);
        }catch (IncorrectResultSizeDataAccessException incorrectResultSizeDataAccessException){
            return null;
        }
    }

    public String addAnimals(List<Animal> animals) {
        animals.forEach(animal -> jdbcTemplate.update("INSERT INTO animal (a_name, age) VALUES (?, ?)", animal.getA_name(), animal.getAge()));
        return "Success";
    }

    public String updateAnimal(Animal animal){
        jdbcTemplate.update("UPDATE animal SET a_name=?, age=? WHERE id=?",
                        animal.getA_name(),animal.getAge(),animal.getId());
        return "Updated";
    }

    public String deleteAnimal(int id) {
        jdbcTemplate.update("DELETE FROM animal WHERE id=?", id);
        return "Removed";
    }
}
