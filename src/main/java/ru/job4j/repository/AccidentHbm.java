package ru.job4j.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import ru.job4j.model.Accident;

import java.util.Collection;

@Repository
public class AccidentHbm {

    private final SessionFactory sf;

    public AccidentHbm(SessionFactory sf) {
        this.sf = sf;
    }

    public Accident create(Accident accident) {
        try (Session session = sf.openSession()) {
            session.save(accident);
            return accident;
        }
    }

    public void update(Accident accident) {
        try (Session session = sf.openSession()){
            Transaction txn = session.beginTransaction();
            session.update(accident);
            txn.commit();
        }
    }

    public void delete(Integer id) {
        Accident accident = new Accident();
        accident.setId(id);
        try (Session session = sf.openSession()) {
            Transaction txn = session.beginTransaction();
            session.delete(accident);
            txn.commit();
        }
    }

    public Accident findById(Integer id) {
        try (Session session = sf.openSession()) {
            return session.createQuery("from Accident a where a.id=:scn", Accident.class)
                    .setParameter("scn", id).getSingleResult();
        }
    }

    public Collection<Accident> findAll() {
        try (Session session = sf.openSession()) {
            return session
                    .createQuery("from Accident", Accident.class)
                    .list();
        }
    }
}
