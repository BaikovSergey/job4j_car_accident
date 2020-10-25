package ru.job4j.repository;

import org.junit.Test;
import ru.job4j.model.Accident;
import ru.job4j.service.AccidentService;

import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class AccidentMemTest {

    @Test
    public void findAllAccidents() {
        AccidentService service = new AccidentService();
        Collection<Accident> list = service.getAllAccidents();
        assertThat(list.size(), is(2));
    }
}