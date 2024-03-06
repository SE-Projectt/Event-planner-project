package org.example.AcceptanceTest;

import MyApp.WeddingPlanningMyApp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class WeddingPlanningTest {
    WeddingPlanningMyApp WPMA ;
    public WeddingPlanningTest()
    {
        WPMA=new WeddingPlanningMyApp() ;
    }
    @Given("the user has started planning")
    public void theUserHasStartedPlanning() {

    }
    @When("the user chooses a  wedding hall named {string} from file {string}")
    public void theUserChoosesAWeddingHallNamedFromFile(String WeddingHallNamed , String file) {
        file="Halls.txt";
        WeddingHallNamed="alameer";
        assertTrue(WPMA.isChickIfExist(WeddingHallNamed,file));
       // assertTrue(WPMA.isHallAvailable(WeddingHallNamed,file,"2024-5-1"));

    }
    @Then("the selected wedding hall named {string} should be recorded on file {string}")
    public void theSelectedWeddingHallNamedShouldBeRecordedOnFile(String  WeddingHallNamed , String file) {
        file="Halls.txt";
        WeddingHallNamed="alameer";
        //assertTrue(WPMA.reserveOnFile(WeddingHallNamed,file));
       // assertTrue(WPMA.reserveAndPrintHall(WeddingHallNamed,file));
        assertTrue(WPMA.reserveAndPrint(WeddingHallNamed,file,"2024-9-9",4));
    }
    @When("the user selects  main course {string} from file {string}")
    public void theUserSelectsMainCourseFromFile(String maincoursename , String filename) {
        maincoursename="piza";
        filename="maincourse.txt";
        assertTrue(WPMA.isChickIfExist(maincoursename,filename));
    }
    @Then("the chosen main course {string} course should be recorded on file {string}")
    public void theChosenMainCourseCourseShouldBeRecordedOnFile(String  maincoursename, String filename) {
        maincoursename="piza";
        filename="maincourse.txt";
        assertTrue(WPMA.reserveOnFile(maincoursename,filename));
    }



    @When("the user selects  desert {string} from file {string}")
    public void theUserSelectsDesertFromFile(String desrtname, String filename) {
        filename="desert.txt";
        desrtname="kunafa";
        assertTrue(WPMA.isChickIfExist(desrtname,filename));
    }
    @Then("the chosen desert {string} course should be recorded on file {string}")
    public void theChosenDesertCourseShouldBeRecordedOnFile(String desrtname, String  filename) {
        filename="desert.txt";
        desrtname="kunafa";
        assertTrue(WPMA.reserveOnFile(desrtname,filename));
    }



    @When("the user hires a DJ {string} from file {string}")
    public void theUserHiresADJFromFile(String djname, String filename) {
        djname="yasmeen";
        filename="Dj.txt";
        assertTrue(WPMA.isChickIfExist(djname,filename));
    }
    @Then("the selected DJ {string} should be recorded on file {string}")
    public void theSelectedDJShouldBeRecordedOnFile(String djname, String filename) {
        djname="yasmeen";
        filename="Dj.txt";
        assertTrue(WPMA.reserveOnFile(djname,filename));
    }


    @When("the user books a photography studio {string} from file {string}")
    public void theUserBooksAPhotographyStudioFromFile(String studioname, String filename) {
        studioname="alahrame";
        filename="studio.txt";
        assertTrue(WPMA.isChickIfExist(studioname,filename));
    }
    @Then("the booked photography studio {string} should be recorded on file {string}")
    public void theBookedPhotographyStudioShouldBeRecordedOnFile(String studioname, String filename) {
        studioname="alahrame";
        filename="studio.txt";
        assertTrue(WPMA.reserveOnFile(studioname,filename));
    }



    @When("the user selects flowers {string} from file {string}")
    public void theUserSelectsFlowersFromFile(String flowername, String filename) {
        flowername="wwww";
        filename="flower.txt";
        assertTrue(WPMA.isChickIfExist(flowername,filename));
    }
    @Then("the ordered flowers  {string} should be recorded on file {string}")
    public void theOrderedFlowersShouldBeRecordedOnFile(String flowername, String  filename) {
        flowername="wwww";
        filename="flower.txt";
        assertTrue(WPMA.reserveOnFile(flowername,filename));
    }
    /////////////////////////////////////// //////////////////////////////////////////////////////////

    @Then("the user check if selected wedding hall named {string} and the wedding date {string} are visible at file {string}")
    public void theUserCheckIfSelectedWeddingHallNamedAndTheWeddingDateAreVisibleAtFile(String hallname, String date, String file) {
        assertTrue(WPMA.checkHallAndDate(hallname,date,file));
    }
    @Then("store the hall {string} and the wedding date {string} at {string} file")
    public void storeTheHallAndTheWeddingDateAtFile(String string, String string2, String string3) {

    }

}
