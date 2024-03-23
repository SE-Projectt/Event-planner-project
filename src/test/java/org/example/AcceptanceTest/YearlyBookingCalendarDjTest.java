package org.example.AcceptanceTest;

import javax.swing.SwingUtilities;
import static org.junit.Assert.*;
import MyApp.LoginMyApp;
import MyApp.SignUpMyApp;
import MyApp.SwitchAccountToProviderMyApp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.YearlyBookingCalendarDj;
import org.junit.Assert;
import org.junit.Test;

public class YearlyBookingCalendarDjTest {
    private String finalDjName;
    private YearlyBookingCalendarDj djCalendar;

    @Given("^a DJ name \"([^\"]*)\"$")
    public void setDjName(String name) {
        finalDjName = name;
    }

    @When("^the application creates a yearly booking calendar for the DJ$")
    public void createYearlyBookingCalendar() {
        SwingUtilities.invokeLater(() -> {
            djCalendar = new YearlyBookingCalendarDj(finalDjName.trim());
        });
    }
    @When("the application creates a yearly booking calendar for the trimmed DJ name")
    public void theApplicationCreatesAYearlyBookingCalendarForTheTrimmedDJName() {

    }
    @Then("the booking calendar for {string} should be successfully created")
    public void theBookingCalendarDjForShouldBeSuccessfullyCreated(String string) {

    }

    // Instance of YearlyBookingCalendarDj
    private YearlyBookingCalendarDj calendarDj;

    // Test DJ Booking Calendar Creation
    @Test
    public void testDjBookingCalendarCreation() {
        // Given a DJ name "DJ Bob"
        String djName = "DJ Bob";

        // When the application creates a yearly booking calendar for the DJ
        calendarDj = new YearlyBookingCalendarDj(djName);

        // Then the booking calendar for "DJ Bob" should be successfully created
        assertNotNull(calendarDj);
        assertEquals(djName, calendarDj.getDjName());
    }

    // Test DJ Name Trimming
    @Test
    public void testDjNameTrimming() {
        // Given a DJ name "  DJ Alice  "
        String djName = "  DJ Alice  ";

        // When the application creates a yearly booking calendar for the trimmed DJ name
        calendarDj = new YearlyBookingCalendarDj(djName.trim());

        // Then the booking calendar for "DJ Alice" should be successfully created
        assertNotNull(calendarDj);
        assertEquals("DJ Alice", calendarDj.getDjName());
    }
}
