package com.example.bilabonnementeksamen2.repositories;

import com.example.bilabonnementeksamen2.models.entities.Lejeaftale;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

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
}
