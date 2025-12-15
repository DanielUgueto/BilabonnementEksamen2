package com.example.bilabonnementeksamen2.repositories;

import com.example.bilabonnementeksamen2.models.entities.Bil;
import com.example.bilabonnementeksamen2.models.enums.BilStatus;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BilRepo {

    private final JdbcTemplate jdbcTemplate;

    public BilRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Bil bil) {
        String sql = """
            INSERT INTO Bil (
                vognnummer, stelnummer, maerke, model,
                antalDoere, antalPersoner, farve,
                drivstoff, gearType, kmTal, kmL,
                fabriksaAar, status
            )
            VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """;

        jdbcTemplate.update(
                sql,
                bil.getVognnummer(),
                bil.getStelnummer(),
                bil.getMaerke(),
                bil.getModel(),
                bil.getAntalDoere(),
                bil.getAntalPersoner(),
                bil.getFarve(),
                bil.getDrivstoff().name(),
                bil.getGearType().name(),
                bil.getKmTal(),
                bil.getKmL(),
                bil.getFabriksAar(),
                bil.getStatus().name()
        );
    }
    public boolean existsByVognnummer(String vognnummer) {
        String sql = "SELECT COUNT(*) FROM Bil WHERE vognnummer = ?";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, vognnummer);
        return count != null && count > 0;
    }

    public boolean existsByStelnummer(String stelnummer) {
        String sql = "SELECT COUNT(*) FROM Bil WHERE stelnummer = ?";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, stelnummer);
        return count != null && count > 0;
    }

    public List<Bil> findAll() {
        String sql = "SELECT * FROM Bil";
        return jdbcTemplate.query(
                sql,
                new BeanPropertyRowMapper<>(Bil.class)
        );
    }

    public void updateStatus(String vognnummer, BilStatus status) {
        String sql = "UPDATE Bil SET status = ? WHERE vognnummer = ?";
        jdbcTemplate.update(sql, status.name(), vognnummer);
    }


}

