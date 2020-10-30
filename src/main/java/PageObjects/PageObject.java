package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObject {

    //instance of webdriver
    protected WebDriver driver;

    //constructor for pageobject
    public PageObject(WebDriver driver){
        this.driver = driver;

        //init elements
        PageFactory.initElements(driver,this);
    }
}
