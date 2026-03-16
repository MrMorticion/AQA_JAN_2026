package org.prog.session19.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.prog.session16.dto.NameDto;
import org.prog.session16.dto.PersonDto;
import org.prog.session16.dto.ResultsDto;
import org.prog.session19.DataHolder;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MySteps {

    @Given("Preconditions are {string}")
    public void preconditionsAreOK(String value) {
        System.out.println(">>>> Preconditions are " + value);
    }

    @Given("Set user password to {string}")
    public void setUserPassword(String value) {
        System.out.println(">>>> User password is set to " + value);
    }

    @Given("There parameters are {string} and {string}")
    public void parametersDemo(String value1, String value2) {
        System.out.println(">>>> There parameters are " + value1 + " and " + value2);
    }

    @When("I do something {int} times")
    public void iDoSomething(int i) {
        for (int j = 1; j <= i; j++) {
            System.out.println(">>>> I do something " + j + " times");
        }
    }

    @Then("Something happens with {}")
    public void somethingHappens(MyEnum myEnum) {
        System.out.println("Something happens with " + myEnum.name());
    }

    @Given("Data table list demo")
    public void dataTableListDemo(DataTable dataTable) {
        for (String s : dataTable.asList(String.class)) {
            System.out.println(s);
        }
    }

    @Given("Data table map demo")
    public void dataTableMapDemo(DataTable dataTable) {
        for (Map.Entry<String, String> e : dataTable.asMap().entrySet()) {
            System.out.println(e.getKey() + " : " + e.getValue());
        }
    }

    @Given("Prepare person data for DB as {string}")
    public void preparePersonData(String alias, DataTable dataTable) {
        ResultsDto resultsDto = new ResultsDto();
        resultsDto.setResults(new ArrayList<>());
        PersonDto personDto = new PersonDto();
        NameDto nameDto = new NameDto();

        nameDto.setFirst(dataTable.asMap().get("FirstName"));
        nameDto.setLast(dataTable.asMap().get("LastName"));
        nameDto.setTitle(dataTable.asMap().get("Title"));
        personDto.setName(nameDto);
        personDto.setGender(dataTable.asMap().get("Gender"));
        personDto.setNat(dataTable.asMap().get("Nat"));
        resultsDto.getResults().add(personDto);

        DataHolder.data.put(alias, resultsDto);
    }
}
