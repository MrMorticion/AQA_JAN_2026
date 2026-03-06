package org.prog.session16;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.sql.*;

//TODO: run this and make sure it works

public class SQLTests {

    private Connection conn;

    @BeforeSuite
    public void beforeSuite() throws SQLException {
        conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/db",
                "root",
                "password"
        );
    }

    @AfterSuite
    public void afterSuite() throws SQLException {
        if (conn != null && !conn.isClosed()) {
            conn.close();
        }
    }

    @Test
    public void testSQL() throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet resultSet = stmt.executeQuery("select * from Persons");

        while (resultSet.next()) {
            String firstName = resultSet.getString("FirstName");
            String lastName = resultSet.getString("LastName");
            String title = resultSet.getString("Title");

            System.out.println(title + " " + firstName + " " + lastName);
        }
    }
}
