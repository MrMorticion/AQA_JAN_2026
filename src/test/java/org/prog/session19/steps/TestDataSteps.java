package org.prog.session19.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import org.prog.session19.DataHolder;

public class TestDataSteps {

    @Given("List of names as {string}")
    public void listOfNamesAs(String alias, DataTable dataTable) {
        DataHolder.data.put(alias, dataTable.asList(String.class));
    }
}
