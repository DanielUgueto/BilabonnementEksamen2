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
            INSERT INTO lejeaftale (kundeID, vognnummer, startDato, slutDato, abonnementstype, maanedligPris, aktiv)
            VALUES (?, ?, ?, ?, ?, ?, ?)
        """;

        jdbcTemplate.update(
                sql,
                lejeaftale.getKundeID(),
                lejeaftale.getVognnummer(),
                lejeaftale.getStartDato(),
                lejeaftale.getSlutDato(),
                lejeaftale.getAbonnementstype().name(),
                lejeaftale.getMaanedligPris(),
                lejeaftale.isAktiv()
        );
    }

    public void afslutLejeaftale(int lejeaftaleID) {
        String sql = """
            UPDATE lejeaftale
            SET aktiv = false
            WHERE lejeaftaleID = ?
        """;
        jdbcTemplate.update(sql, lejeaftaleID);

    }

    //    BeanPropertyRowMapper bruges til at mappe matchende sql felter
//    og lave dem til java objekter, hvor det bagefter bliver lavet en liste af Lejeaftale-objekter
    public List<Lejeaftale> findAll() {
        String sql = "SELECT * FROM lejeaftale";
        return jdbcTemplate.query(
                sql,
                new BeanPropertyRowMapper<>(Lejeaftale.class)
        );
    }

    //siden oplysningerne om indtægten ligger i lejeaftalen, ligger vores metode her selvom den bruger en innerjoin med bil
    public List<Lejeaftale> findUdlejedeLejeaftaler() {
        String sql = """
            SELECT l.*
            FROM lejeaftale l
            INNER JOIN bil b ON l.vognnummer = b.vognnummer
            WHERE b.status = 'UDLEJET'
        """;

        return jdbcTemplate.query(
                sql,
                new BeanPropertyRowMapper<>(Lejeaftale.class)
        );

    }
}
