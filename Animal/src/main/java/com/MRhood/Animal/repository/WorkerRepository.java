package com.MRhood.Animal.repository;

import com.MRhood.Animal.model.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WorkerRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;
    public List<Worker> getAll() {
        return jdbcTemplate.query("SELECT id,w_name,age,pupil_id FROM worker", BeanPropertyRowMapper.newInstance(Worker.class));
    }


    public Worker getSingle(int id) {
        try{
            return jdbcTemplate.queryForObject("SELECT id,w_name,age,pupil_id FROM worker WHERE id=?", BeanPropertyRowMapper.newInstance(Worker.class),id);
        }catch (IncorrectResultSizeDataAccessException incorrectResultSizeDataAccessException){
            return null;
        }
    }

    public String addWorkers(List<Worker> workers) {
        workers.forEach(worker -> jdbcTemplate.update("INSERT INTO worker (id,w_name,age,pupil_id) VALUES (?,?,?,?)",worker.getId(),worker.getW_name(),worker.getAge(),worker.getPupil_id())
        );
        return "Success!";
    }


    public String updateWorker(Worker worker) {
        jdbcTemplate.update("UPDATE worker SET w_name=?,age=?,pupil_id=? WHERE id=?", worker.getW_name(), worker.getAge(), worker.getPupil_id(), worker.getId());
        return "Updated";
    }
}
