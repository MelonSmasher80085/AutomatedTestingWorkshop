package de.doubleslash.todolist.apitest.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TaskStepDefinitions {

    @Given("{int} tasks are open")
    public void tasksAreOpen(int arg0) {
    }

    @When("all tasks are requested")
    public void allTasksAreRequested() {
    }

    @Then("the server should respond with {int}")
    public void theServerShouldRespondWith(int arg0) {
    }
}