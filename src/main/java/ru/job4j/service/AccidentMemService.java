package ru.job4j.service;

import org.springframework.stereotype.Service;
import ru.job4j.model.Accident;
import ru.job4j.repository.AccidentMem;

import java.util.Collection;

//@Service
public class AccidentMemService {

    private final AccidentMem accidentMem = new AccidentMem();

    public void addAccident(Accident accident) {
        this.accidentMem.addAccident(accident);
    }

    public void updateAccident(Accident accident) {
        this.accidentMem.updateAccident(accident);
    }

    public void deleteAccident(int id) {
        this.accidentMem.deleteAccident(id);
    }

    public Collection<Accident> getAllAccidents() {
        return this.accidentMem.findAllAccidents();
    }

    public Accident getAccidentById(Integer id) {
        return this.accidentMem.findAccidentById(id);
    }

}
