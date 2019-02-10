package com.cybertek.steps;
import com.cybertek.pages.ProductPage;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import com.cybertek.utilities.Pages;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import static com.cybertek.utilities.BrowserUtils.*;

public class FilteringSteps extends BrowserUtils {

    Pages pages = new Pages();


    @Given("user goes to the main page {string}")
    public void user_goes_to_the_main_page(String string) {
        string = ConfigurationReader.getProperty("url");
        Driver.getDriver().get(string);
    }

    @Then("user clicks on the link {string}")
    public void user_clicks_on_the_link(String product) {
        product=ConfigurationReader.getProperty("product");
        clickByText(product).click();

    }

    @Then("user types in the make and model text box {string}")
    public void user_types_in_the_make_and_model_text_box(String make) {
        make=ConfigurationReader.getProperty("make");
        pages.mainPage().makeBox.sendKeys(make);

    }

    @Then("user types in the miles text box {string}")
    public void user_types_in_the_miles_text_box(String miles) {
        miles = ConfigurationReader.getProperty("miles");
        pages.mainPage().milesFromZipBox.sendKeys(miles);
    }

    @Then("user types in the ZIP text box {string}")
    public void user_types_in_the_ZIP_text_box(String zip) {
        zip = ConfigurationReader.getProperty("zipCode");
        pages.mainPage().zipCodeBox.sendKeys(zip);
    }

    @Then("user types in the year text box {string}")
    public void user_types_in_the_year_text_box(String minYear) {
        minYear = ConfigurationReader.getProperty("minYear");
        pages.mainPage().minYearBox.sendKeys(minYear);
    }

    @Then("user types in the min engine displacement text box {string}")
    public void user_types_in_the_min_engine_displacement_text_box(String engineSize) {
        engineSize = ConfigurationReader.getProperty("engineSize");
        pages.mainPage().engineDisplacementBox.sendKeys(engineSize+Keys.ENTER);
    }

    @When("the filtered options of {string} appear on the page")
    public void the_filtered_options_of_appear_on_the_page(String product) {
        product=ConfigurationReader.getProperty("product");
        Assert.assertTrue(Driver.getDriver().getTitle().contains(product));
    }


    @Then("year of the selected motorcycle must be greater or equal to {string}")
    public void year_of_the_selected_motorcycle_must_be_greater_or_equal_to(String actualYear) {
        String make=ConfigurationReader.getProperty("make");
        String minYear = ConfigurationReader.getProperty("minYear");
        clickByPartialText(make).click(); // we are in the product page now
        waitForPageToLoad(6);
        System.out.println(Driver.getDriver().getTitle());
        pages.productPage().yearTextBox.getText();
        String yearText = pages.productPage().yearTextBox.getText();
        System.out.println(yearText);
        String [] yearWords = yearText.split(" ");
        System.out.println(yearWords[0]);
        String minYearAsText =yearWords[0];
        int year = Integer.valueOf(minYearAsText);
        Assert.assertTrue("the year is not as filetered",year>=Integer.valueOf(minYear));



    }

    @Then("min engine displacement of the selected motorcycle must be greater or equal to {string}")
    public void min_engine_displacement_of_the_selected_motorcycle_must_be_greater_or_equal_to(String string) {
        String engineSize = ConfigurationReader.getProperty("engineSize"); // entered data
        String actualEngineSizeText = pages.productPage().engineDisplacmentText.getText();
        String [] actualEngineWords =actualEngineSizeText.split(":");
        String actualEnginSize = actualEngineWords[1].trim();
        int actualEngineSizeAsInt =Integer.valueOf(actualEnginSize);
        System.out.println(actualEngineSizeAsInt);
        System.out.println(Integer.valueOf(engineSize));
        Assert.assertTrue(actualEngineSizeAsInt>=Integer.valueOf(engineSize));


    }
}
