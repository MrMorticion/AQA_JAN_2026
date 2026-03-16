package org.prog.session19.steps;

import io.cucumber.java.en.Given;
import org.prog.session16.dto.PersonDto;
import org.prog.session16.dto.ResultsDto;
import org.prog.session19.DataHolder;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBSteps {

    public static Connection connection;

    @Given("I store {string} in DB")
    public void storePeopleInDB(String alias) throws SQLException {
        //turn them to java list
        ResultsDto resultsDto = (ResultsDto) DataHolder.data.get(alias);
        List<PersonDto> persons = resultsDto.getResults();

        //for each element in list -> record to DB
        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO Persons (FirstName, LastName, Gender, Title, Nat) " +
                        "VALUES (?, ?, ?, ?, ?)");

        for (PersonDto person : persons) {
            preparedStatement.setString(1, person.getName().getFirst());
            preparedStatement.setString(2, person.getName().getLast());
            preparedStatement.setString(3, person.getGender());
            preparedStatement.setString(4, person.getName().getTitle());
            preparedStatement.setString(5, person.getNat());
            try {
                preparedStatement.execute();
            } catch (SQLException e) {
                System.out.println("Failed to insert into DB " + person);
            }
        }
    }

    @Given("I pick {int} random person from DB as {string}")
    public void pickRandomPersonFromDB(int amount, String alias) throws SQLException {
        Statement stmt = connection.createStatement();
        ResultSet resultSet = stmt.executeQuery("select * from Persons ORDER BY RAND() LIMIT " + amount);

        List<String> randomNames = new ArrayList<>();
        while (resultSet.next()) {
            String firstName = resultSet.getString("FirstName");
            String lastName = resultSet.getString("LastName");
            randomNames.add(firstName + " " + lastName);
        }
        DataHolder.data.put(alias, randomNames);
    }
}
