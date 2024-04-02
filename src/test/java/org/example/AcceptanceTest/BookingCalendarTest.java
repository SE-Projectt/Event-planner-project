package org.example.AcceptanceTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.YearlyBookingCalendar;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BookingCalendarTest {

    private YearlyBookingCalendar bookingCalendar;

    @Given("The Yearly Booking Calendar is open for {string}")
    public void theYearlyBookingCalendarIsOpenFor(String hallName) {
        bookingCalendar = new YearlyBookingCalendar(hallName);
    }

    @When("The user selects a date to book")
    public void theUserSelectsADateToBook() {
   
        bookingCalendar.bookDate("2024-03-22");
    }

    @Then("The date should be booked successfully for {string}")
    public void theDateShouldBeBookedSuccessfullyFor(String hallName) {
        assertTrue("Date should be booked successfully", bookingCalendar.bookedDatesPerHall.get(hallName).contains("2024-03-22"));
    }

    @Given("The date is already booked for {string}")
    public void theDateIsAlreadyBookedFor(String hallName) {
        // You may implement logic to set up the initial state where the date is already booked for the given hall
    }

    @When("The user tries to book the same date")
    public void theUserTriesToBookTheSameDate() {
        // You may implement logic to simulate the user trying to book the same date
    }

    @Then("The system should not allow booking the already booked date")
    public void theSystemShouldNotAllowBookingTheAlreadyBookedDate() {
        String hallName = "HallName";
        assertFalse("System should not allow booking already booked date", bookingCalendar.hasDuplicateDates("bookingHall.txt", hallName));
    }
}
