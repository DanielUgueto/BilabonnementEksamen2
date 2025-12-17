package com.example.bilabonnementeksamen2.repositories;

import com.example.bilabonnementeksamen2.models.entities.Skadesrapport;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SkadesrapportRepo {

    private final JdbcTemplate jdbcTemplate;

    public SkadesrapportRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Skadesrapport rapport) {
        String sql = """
                    INSERT INTO skadesrapport (lejeaftaleID, dato, totalPris)
                    VALUES (?, ?, ?)
                """;

        jdbcTemplate.update(sql, rapport.getLejeaftaleID(), rapport.getDato(), rapport.getTotalPris()
        );
    }

    public void opdaterTotalPris(int rapportID, double pris) {
        String sql = """
        UPDATE skadesrapport
        SET totalPris = totalPris + ?
        WHERE rapportID = ?
    """;
        jdbcTemplate.update(sql, pris, rapportID);
    }
    public void markAfsluttet(int rapportID) {
        String sql = """
            UPDATE skadesrapport
            SET dato = CURDATE()
            WHERE rapportID = ?
        """;

        jdbcTemplate.update(sql, rapportID);
    }

//
//    public List<Skadesrapport> findKlarTilGennemgang() {
//    }
}
