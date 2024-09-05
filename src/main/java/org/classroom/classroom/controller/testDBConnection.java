package org.classroom.classroom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RestController
@RequestMapping("/api/test")
public class testDBConnection {

    @Autowired
    private DataSource dataSource;

    @GetMapping("/db-check")
    public String checkDatabaseConnection() {
        try (Connection connection = dataSource.getConnection()) {
            if (connection != null) {
                return "Database is connected!";
            } else {
                return "Failed to connect to database!";
            }
        } catch (SQLException e) {
            return "Error: " + e.getMessage();
        }
    }
}

