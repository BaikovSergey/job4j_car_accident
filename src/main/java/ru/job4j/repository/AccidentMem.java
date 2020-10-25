package ru.job4j.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.model.Accident;

import java.util.*;

@Repository
public class AccidentMem {

    private Map<Integer, Accident> accidents;

    public AccidentMem() {
        this.accidents = new HashMap<>();
        this.accidents.put(1, new Accident(1, "First accident", "First accident text",
                "First accident address"));
        this.accidents.put(2, new Accident(2, "Second accident", "Second accident text",
                "Second accident address"));
    }

    public void addAccident(Accident accident) {
        this.accidents.put(accident.getId(), accident);
    }

    public Accident findAccidentById(Integer id) {
        Accident result = new Accident(0, "", "", "");
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
