package ru.netology.data;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;


@UtilityClass
public class Database {

    private Connection connection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "dima", "pass");
    }

    @SneakyThrows
    private String getDebitStatus() {
        var statusQuery = "SELECT * FROM payment_entity;";
        try (var statement = connection().createStatement()) {
            try (var rs = statement.executeQuery(statusQuery)) {
                rs.next();
                return rs.getString("status");
            }
        }
    }

    @SneakyThrows
    private String getCreditStatus() {
        var statusQuery = "SELECT * FROM credit_request_entity;";
        try (var statement = connection().createStatement()) {
            try (var rs = statement.executeQuery(statusQuery)) {
                rs.next();
                return rs.getString("status");
            }
        }
    }

    public void checkApprovedBuy() {
        assertEquals("APPROVED", getDebitStatus());
    }

    public void checkDeclinedBuy() {
        assertEquals("DECLINED", getDebitStatus());
    }

    public void checkApprovedBuyTourCredit() {
        assertEquals("APPROVED", getCreditStatus());
    }

    public void checkDeclinedBuyTourCredit() {
        assertEquals("DECLINED", getCreditStatus());
    }
}