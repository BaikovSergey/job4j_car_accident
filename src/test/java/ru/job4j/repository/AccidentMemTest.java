package ru.job4j.repository;

import org.junit.Test;
import ru.job4j.model.Accident;
import ru.job4j.service.AccidentMemService;

import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class AccidentMemTest {

    @Test
    public void findAllAccidents() {
        AccidentMemService service = new AccidentMemService();
        Collection<Accident> list = service.getAllAccidents();
        assertThat(list.size(), is(2));
    }
}