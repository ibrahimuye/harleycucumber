package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    public MainPage () {
        PageFactory.initElements(Driver.getDriver(), this);
    }

     @FindBy(xpath = "//input[@class='flatinput auto_make_model ui-autocomplete-input']")
    public WebElement makeBox;

    @FindBy(name = "search_distance")
    public WebElement milesFromZipBox;

    @FindBy(name = "postal")
    public WebElement zipCodeBox;

    @FindBy(name = "min_auto_year")
    public WebElement minYearBox;

    @FindBy(name = "min_engine_displacement_cc")
    public WebElement engineDisplacementBox;




}
