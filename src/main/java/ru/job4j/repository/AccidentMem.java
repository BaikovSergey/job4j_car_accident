package ru.job4j.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.model.Accident;

import java.util.*;

@Repository
public class AccidentMem {

    private Integer id = 3;

    private Map<Integer, Accident> accidents;

    public AccidentMem() {
        this.accidents = new HashMap<>();
        this.accidents.put(1, new Accident("First accident", "First accident text",
                "First accident address"));
        this.accidents.put(2, new Accident("Second accident", "Second accident text",
                "Second accident address"));
    }

    public void addAccident(Accident accident) {
        accident.setId(this.id);
        this.accidents.put(this.id, accident);
        this.id++;
    }

    public Accident findAccidentById(Integer id) {
        Accident result = new Accident("", "", "");
        result.setId(0);
        if (accidents.containsKey(id)) {
            result =  this.accidents.get(id);
        }
            return result;
    }

    public Collection<Accident> findAllAccidents() {
        List<Accident> result = new ArrayList<>();
        for (Map.Entry<Integer, Accident> entry : this.accidents.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }
}
