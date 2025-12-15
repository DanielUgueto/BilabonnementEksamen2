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

    public void save(Skade skade) {
        String sql = """
            INSERT INTO Skade (rapportID, beskrivelse, pris)
            VALUES (?, ?, ?)
        """;

        jdbcTemplate.update(sql, skade.getRapportID(), skade.getBeskrivelse(), skade.getPris()
        );
    }

    public double sumPrisByRapportID(int rapportID) {
        String sql = "SELECT SUM(pris) FROM Skade WHERE rapportID = ?";
        return jdbcTemplate.queryForObject(sql, Double.class, rapportID);
    }
}
