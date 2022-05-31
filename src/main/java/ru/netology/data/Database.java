package ru.netology.data;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;


@UtilityClass
public class Database {

    private static String url = System.getProperty("url");
    private static String user = System.getProperty("user");
    private static String pass = System.getProperty("pass");

    private Connection connection() throws SQLException {
        return DriverManager.getConnection(url, user, pass);
    }

    @SneakyThrows
    private String getDebitStatus() {
        var statusQuery = "SELECT * FROM payment_entity ORDER BY created DESC;";
        try (var statement = connection().createStatement()) {
            try (var rs = statement.executeQuery(statusQuery)) {
                rs.next();
                return rs.getString("status");
            }
        }
    }

    @SneakyThrows
    private String getCreditStatus() {
        var statusQuery = "SELECT * FROM credit_request_entity ORDER BY created DESC;";
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