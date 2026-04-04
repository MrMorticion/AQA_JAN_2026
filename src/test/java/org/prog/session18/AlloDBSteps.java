package org.prog.session18;

import io.cucumber.java.en.Then;
import org.prog.session19.DataHolder;
import org.testng.Assert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;

public class AlloDBSteps {

    private static final String PHONE_TABLE_NAME = "Phones";
    private static final String PHONE_ID_COLUMN = "PhoneID";
    private static final String PHONE_MODEL_COLUMN = "Model";
    private static final String PHONE_PRICE_COLUMN = "Price";

    public static Connection conn;

    @Then("I check Allo phones in DB from {string} and save missing ones")
    public void checkAlloPhonesInDBAndSaveMissingOnes(String alias) throws SQLException {
        List<Map<?, ?>> phones = (List<Map<?, ?>>) DataHolder.data.get(alias);
        Assert.assertNotNull(phones, "No Allo phones found by alias: " + alias);
        Assert.assertFalse(phones.isEmpty(), "No Allo phones were collected from the page");

        ensurePhoneTableExists();

        try (PreparedStatement selectStatement = conn.prepareStatement(
                "SELECT " + PHONE_PRICE_COLUMN + " FROM " + PHONE_TABLE_NAME + " WHERE " + PHONE_MODEL_COLUMN + " = ?");
             PreparedStatement insertStatement = conn.prepareStatement(
                     "INSERT INTO " + PHONE_TABLE_NAME + " (" + PHONE_MODEL_COLUMN + ", " + PHONE_PRICE_COLUMN + ") VALUES (?, ?)")) {

            for (Map<?, ?> phone : phones) {
                String model = String.valueOf(phone.get("model"));
                int price = ((Number) phone.get("price")).intValue();
                OptionalInt dbPrice = findPhonePrice(selectStatement, model);
                if (dbPrice.isPresent()) {
                    Assert.assertEquals(
                            dbPrice.getAsInt(),
                            price,
                            "DB price mismatch for phone: " + model
                    );
                } else {
                    insertStatement.setString(1, model);
                    insertStatement.setInt(2, price);
                    insertStatement.execute();
                }
            }
        }
    }

    private void ensurePhoneTableExists() throws SQLException {
        try (PreparedStatement createStatement = conn.prepareStatement(
                "CREATE TABLE IF NOT EXISTS " + PHONE_TABLE_NAME + " (" +
                        PHONE_ID_COLUMN + " INT UNIQUE AUTO_INCREMENT NOT NULL, " +
                        PHONE_MODEL_COLUMN + " VARCHAR(255) NOT NULL, " +
                        PHONE_PRICE_COLUMN + " INT NOT NULL, " +
                        "PRIMARY KEY (" + PHONE_ID_COLUMN + "), " +
                        "UNIQUE (" + PHONE_MODEL_COLUMN + ")" +
                        ")")) {
            createStatement.execute();
        }
    }

    private OptionalInt findPhonePrice(PreparedStatement statement, String model) throws SQLException {
        statement.setString(1, model);
        try (ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                return OptionalInt.of(resultSet.getInt(PHONE_PRICE_COLUMN));
            }
        }
        return OptionalInt.empty();
    }
}