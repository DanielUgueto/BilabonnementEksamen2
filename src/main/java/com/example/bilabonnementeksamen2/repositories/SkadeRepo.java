package com.example.bilabonnementeksamen2.repositories;

import com.example.bilabonnementeksamen2.models.entities.Skade;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SkadeRepo {

    private final JdbcTemplate jdbcTemplate;

    public SkadeRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public double sumPrisByRapportID(int rapportID) {
        String sql = "SELECT SUM(pris) FROM skade WHERE rapportID = ?";
        return jdbcTemplate.queryForObject(sql, Double.class, rapportID);
    }

    public void save(int rapportID, String beskrivelse, double pris) {
        String sql = """
        INSERT INTO skade (rapportID, beskrivelse, pris)
        VALUES (?, ?, ?)
    """;

        jdbcTemplate.update(sql, rapportID, beskrivelse, pris);
    }



}
