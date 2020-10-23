package ru.job4j.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.model.Accident;
import java.util.Map;

@Repository
public class AccidentMem {

    private Map<Integer, Accident> accidents;

}
