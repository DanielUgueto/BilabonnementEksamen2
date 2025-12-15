package com.example.bilabonnementeksamen2.repositories;

import com.example.bilabonnementeksamen2.models.entities.Skadesrapport;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SkadesrapportRepo {

    private final JdbcTemplate jdbcTemplate;

    public SkadesrapportRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Skadesrapport rapport) {
        String sql = """
                    INSERT INTO Skadesrapport (lejeaftaleID, dato, totalPris)
                    VALUES (?, ?, ?)
                """;

        jdbcTemplate.update(sql, rapport.getLejeaftaleID(), rapport.getDato(), rapport.getTotalPris()
        );
    }

    public void updateTotalPris(int rapportID) {
        String sql = """
            UPDATE Skadesrapport
            SET totalPris = (
                SELECT COALESCE(SUM(pris), 0)
                FROM Skade
                WHERE rapportID = ?
            )
            WHERE rapportID = ?
        """;

        jdbcTemplate.update(sql, rapportID, rapportID);
    }

}
