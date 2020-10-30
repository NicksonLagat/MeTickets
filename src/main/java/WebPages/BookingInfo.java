package WebPages;

import PageObjects.PageObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class BookingInfo extends PageObject {

    @FindBy(id = "fullnames_1")
    private WebElement full_names;

    @FindBy(id = "ids_1")
    private WebElement ids;

    @FindBy(id = "gender_1")
    private WebElement gender;

    @FindBy(id = "nationality_1")
    private WebElement nationality;

    @FindBy(id = "pay_mobile")
    private WebElement pay_mobile;

    @FindBy(id = "pay_email")
    private WebElement pay_email;


    @FindBy(name = "terms")
    private WebElement terms;

    @FindBy(xpath = "//*[@id=\"recaptcha-anchor\"]")
    private WebElement recaptcha;


    public BookingInfo(WebDriver driver) {
        super(driver);
    }

    public void confirmBooking(){

        this.full_names.sendKeys("Bazuu Kalale");
        this.ids.sendKeys("39197300");
        Select gd = new Select(this.gender);
        gd.selectByValue("M");
        Select nat = new Select(this.nationality);
        nat.selectByValue("Kenya");
        this.pay_mobile.sendKeys("0709309181");
        this.pay_email.sendKeys("info@krc.co.ke");

        WebElement te = this.terms;
        for(int i=0; i<2; i++){
            te.click();
            System.out.println("I was clicked");
        }


    }
}
