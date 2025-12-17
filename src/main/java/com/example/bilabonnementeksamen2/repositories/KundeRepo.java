package com.example.bilabonnementeksamen2.repositories;

import com.example.bilabonnementeksamen2.models.entities.Kunde;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class KundeRepo {

    private final JdbcTemplate jdbcTemplate;

    public KundeRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Kunde kunde) {
        String sql = """
            INSERT INTO kunde (koerekortNummer, cprNummer, navn, adresse, telefon, email)
            VALUES (?, ?, ?, ?, ?, ?)
        """;

        jdbcTemplate.update(
                sql,
                kunde.getKoerekortNummer(),
                kunde.getCprNummer(),
                kunde.getNavn(),
                kunde.getAdresse(),
                kunde.getTelefon(),
                kunde.getEmail()
        );
    }

    public List<Kunde> findAll() {
        return jdbcTemplate.query(
                "SELECT * FROM kunde",
                new BeanPropertyRowMapper<>(Kunde.class)
        );
    }
}
