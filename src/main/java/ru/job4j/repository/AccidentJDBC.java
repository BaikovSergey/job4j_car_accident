package ru.job4j.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.job4j.model.Accident;

import java.util.Collection;

@Repository
public class AccidentJDBC {

    private final JdbcTemplate jdbc;

    public AccidentJDBC(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public Accident create(Accident accident) {
        jdbc.update("insert into accident (name, text, address) values (?, ?, ?)",
                accident.getName(), accident.getText(), accident.getAddress());
        return accident;
    }

    public void update(Accident accident) {
        jdbc.update("update accident set name = ?, text = ?, address = ? where id = ?",
                accident.getName(), accident.getText(), accident.getAddress(), accident.getId());
    }

    public void delete(Integer id) {
        jdbc.update("delete from accident where id = ?", id);
    }

    public Accident findById(Integer id) {
        return jdbc.queryForObject(
                "select * from accident where id = ?",
                (rs, row) -> {
                    Accident accident = new Accident();
                    accident.setId(rs.getInt("id"));
                    accident.setName(rs.getString("name"));
                    accident.setText(rs.getString("text"));
                    accident.setAddress(rs.getString("address"));
                    return accident;
                },
                id);
    }

    public Collection<Accident> findAll() {
        return jdbc.query("select id, name, text, address from accident",
                (rs, row) -> {
                    Accident accident = new Accident();
                    accident.setId(rs.getInt("id"));
                    accident.setName(rs.getString("name"));
                    accident.setText(rs.getString("text"));
                    accident.setAddress(rs.getString("address"));
                    return accident;
                });
    }
}
