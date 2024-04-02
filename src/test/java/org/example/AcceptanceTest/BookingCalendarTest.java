package org.example.AcceptanceTest;
import MyApp.LoginMyApp;
import MyApp.SignUpMyApp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.*;

import io.cucumber.java.en.*;
import org.example.YearlyBookingCalendar;

import java.util.HashSet;

public class BookingCalendarTest {

    private YearlyBookingCalendar bookingCalendar;

    @Given("The Yearly Booking Calendar is open for {string}")
    public void theYearlyBookingCalendarIsOpenFor(String hallName) {
        bookingCalendar = new YearlyBookingCalendar(hallName);
    }

    @When("The user selects a date to book")
    public void theUserSelectsADateToBook() {
        // For the sake of this example, let's assume the user clicks on a date
        // This action could be simulated by directly invoking the bookDate method of the calendar
        // You may need to adjust this step based on how the actual UI interaction is implemented
        bookingCalendar.bookDate("2024-03-22");
    }

    @Then("The date should be booked successfully for {string}")
    public void theDateShouldBeBookedSuccessfullyFor(String hallName) {
        assertTrue("Date should be booked successfully", bookingCalendar.bookedDatesPerHall.get(hallName).contains("2024-03-22"));
    }

    @Given("The date is already booked for {string}")
    public void theDateIsAlreadyBookedFor(String hallName) {

    }

    @When("The user tries to book the same date")
    public void theUserTriesToBookTheSameDate() {

    }

    @Then("The system should not allow booking the already booked date")
    public void theSystemShouldNotAllowBookingTheAlreadyBookedDate() {
        String hallName = "HallName";
        assertFalse("System should not allow booking already booked date", bookingCalendar.hasDuplicateDates("bookingHall.txt", hallName));
    }
}
