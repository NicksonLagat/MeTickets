package WebPages;

import PageObjects.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SearchResults extends PageObject {

    @FindBy(xpath = "//*[@id=\"car-details\"]")
    private WebElement car_details;

    @FindBy(id = "adults")
    private WebElement adults;

    @FindBy(id = "coach")
    private WebElement coach;

    @FindBy(xpath = "//*[@id=\"car-details\"]/div/div[3]/div[2]/button")
    private WebElement book;

    

    public SearchResults(WebDriver driver) {
        super(driver);
    }

    public void searchResults(){

        //this.car_details.isDisplayed();
        String SEARCH_RESULTS = this.car_details.getText();
        if(SEARCH_RESULTS.contentEquals(this.car_details.getText())){

            System.out.println("Results Matched");
        }

        else if(!SEARCH_RESULTS.contentEquals(this.car_details.getText())){

            System.out.println("reload");
        }


    }


    public void enterbookingDetails(){

        Select adt = new Select(this.adults);
        adt.selectByValue("1");

        Select coa = new Select(this.coach);
        coa.selectByValue("FirstClass");

        this.book.click();



    }
}
