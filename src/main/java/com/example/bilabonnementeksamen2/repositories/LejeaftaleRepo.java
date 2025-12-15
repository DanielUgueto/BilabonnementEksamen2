package com.example.bilabonnementeksamen2.repositories;

import com.example.bilabonnementeksamen2.models.entities.Lejeaftale;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LejeaftaleRepo {

    private final JdbcTemplate jdbcTemplate;

    public LejeaftaleRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Lejeaftale lejeaftale) {
        String sql = """
            INSERT INTO Lejeaftale (
                kundeID, vognnummer,
                startDato, slutDato,
                abonnementsType, maanedligPris, aktiv
            )
            VALUES (?, ?, ?, ?, ?, ?, ?)
        """;

        jdbcTemplate.update(
                sql,
                lejeaftale.getKundeID(),
                lejeaftale.getVognnummer(),
                lejeaftale.getStartDato(),
                lejeaftale.getSlutDato(),
                lejeaftale.getAbonnementsType().name(),
                lejeaftale.getMaanedligPris(),
                lejeaftale.isAktiv()
        );
    }

    public void afslutLejeaftale(int lejeaftaleID) {
        String sql = """
            UPDATE Lejeaftale
            SET aktiv = false
            WHERE lejeaftaleID = ?
        """;
        jdbcTemplate.update(sql, lejeaftaleID);

    }

    public List<Lejeaftale> findAll() {
        String sql = "SELECT * FROM Lejeaftale";
        return jdbcTemplate.query(
                sql,
                new BeanPropertyRowMapper<>(Lejeaftale.class)
        );
    }

}
