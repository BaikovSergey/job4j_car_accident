package ru.job4j.repository;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.Test;
import ru.job4j.model.Accident;
import java.util.Collection;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class AccidentHbmTest {

    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();

    private SessionFactory sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();

    @Test
    public void create() {
        AccidentHbm hibernate = new AccidentHbm(sf);
        Accident expected = new Accident("name", "text", "address");
        int id = hibernate.create(expected).getId();
        expected.setId(id);
        Collection<Accident> list = hibernate.findAll();
        Accident result = list.iterator().next();
        assertThat(result, is(expected));
    }

    @Test
    public void update() {
        AccidentHbm hibernate = new AccidentHbm(sf);
        Accident expected = new Accident("name", "text", "address");
        hibernate.create(expected);
        expected.setName("Changed");
        hibernate.update(expected);
        Accident result = hibernate.findAll().iterator().next();
        assertThat(result.getName(), is("Changed"));

    }

    @Test
    public void delete() {
        AccidentHbm hibernate = new AccidentHbm(sf);
        Accident accident = new Accident();
        int id = hibernate.create(accident).getId();
        hibernate.delete(id);
        Collection<Accident> list = hibernate.findAll();
        assertThat(list.size(), is(0));
    }

    @Test
    public void findById() {
        AccidentHbm hibernate = new AccidentHbm(sf);
        Accident expected = new Accident("name", "text", "address");
        int id = hibernate.create(expected).getId();
        expected.setId(id);
        Accident result = hibernate.findById(id);
        assertThat(result, is(expected));
    }

    @Test
    public void findAll() {
        AccidentHbm hibernate = new AccidentHbm(sf);
        Accident accident = new Accident();
        hibernate.create(accident);
        Collection<Accident> list = hibernate.findAll();
        assertThat(list.size(), is(1));
    }
}