package org.example.AcceptanceTest;

import io.cucumber.datatable.internal.difflib.ChangeDelta;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.YearlyBookingCalendar;
import org.junit.Test;

import javax.swing.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class YearlyBookingCalendarhallTest {
    private YearlyBookingCalendar calendarHalls;

    // Test Hall Booking Calendar Creation
    @Given("^a hall name \"([^\"]*)\"$")
    public void setHallName(String name) {
        SwingUtilities.invokeLater(() -> {
            calendarHalls = new YearlyBookingCalendar(name.trim());
        });
    }

    // Test Hall Name Trimming
    @When("the application creates a yearly booking calendar for the hall")
    public void theApplicationCreatesAYearlyBookingCalendarForTheHall() {

    }
    @When("the application creates a yearly booking calendar for the trimmed hall name")
    public void theApplicationCreatesAYearlyBookingCalendarForTheTrimmedHallName() {

    }

    // Method to be tested
    public void theBookingCalendarHallsForShouldBeSuccessfullyCreated(String hallName) {
        // In a real scenario, you would likely instantiate YearlyBookingCalendar here
        // For the purpose of this test, we're just mocking the behavior
        YearlyBookingCalendar calendar = new YearlyBookingCalendar(hallName);
    }

}
