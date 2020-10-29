package ru.job4j.service;

import org.springframework.stereotype.Service;
import ru.job4j.model.Accident;
import ru.job4j.repository.AccidentHbm;

import java.util.Collection;

@Service
public class AccidentHbmService {

    private final AccidentHbm accidentHbm;

    public AccidentHbmService(AccidentHbm accidentHbm) {
        this.accidentHbm = accidentHbm;
    }

    public Accident create(Accident accident) {
        return this.accidentHbm.create(accident);
    }

    public void update(Accident accident) {
        this.accidentHbm.update(accident);
    }

    public void delete(Integer id) {
        this.accidentHbm.delete(id);
    }

    public Accident findById(Integer id) {
        return this.accidentHbm.findById(id);
    }

    public Collection<Accident> findAll() {
        return this.accidentHbm.findAll();
    }
}
