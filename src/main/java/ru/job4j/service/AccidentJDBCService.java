package ru.job4j.service;

import org.springframework.stereotype.Service;
import ru.job4j.model.Accident;
import ru.job4j.repository.AccidentJDBC;

import java.util.Collection;

//@Service
public class AccidentJDBCService {

    private final AccidentJDBC jdbcTemplate;

    public AccidentJDBCService(AccidentJDBC jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Accident create(Accident accident) {
        return this.jdbcTemplate.create(accident);
    }

    public void update(Accident accident) {
        this.jdbcTemplate.update(accident);
    }

    public void delete(Integer id) {
        this.jdbcTemplate.delete(id);
    }

    public Accident findById(Integer id) {
        return this.jdbcTemplate.findById(id);
    }

    public Collection<Accident> findAll() {
        return this.jdbcTemplate.findAll();
    }
}
